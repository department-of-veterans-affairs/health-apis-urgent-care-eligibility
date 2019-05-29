#!/usr/bin/env bash

ENDPOINT_DOMAIN_NAME="$K8S_LOAD_BALANCER"
ENVIRONMENT="$K8S_ENVIRONMENT"
TOKEN="$TOKEN"
PATIENT="$PATIENT"
#.well-known doesn't exist yet
PATHS=(/fhir/v0/r4/metadata \
/fhir/v0/r4/openapi.json \
/fhir/v0/r4/openapi.yaml)
SUCCESS=0
FAILURE=0

usage() {
  cat <<EOF
  Commands
    smoke-test [--endpoint-domain-name|-d <endpoint>] [--environment|-e <env>]
    regression-test [--endpoint-domain-name|-d <endpoint>] [--environment|-e <env>]

  Example
    smoke-test
      --endpoint-domain-name= localhost
      --environment=qa


$1
EOF
exit 1
}

doCurl () {
  REQUEST_URL="$ENDPOINT_DOMAIN_NAME$path"
  if [[ -n "$2" ]]
  then
    status_code=$(curl -k -H "Authorization: Bearer $2" --write-out %{http_code} --silent --output /dev/null "$REQUEST_URL")
  else
    status_code=$(curl -k --write-out %{http_code} --silent --output /dev/null "$REQUEST_URL")
  fi

  if [[ "$status_code" == $1 ]]
  then
    SUCCESS=$((SUCCESS + 1))
    echo "$REQUEST_URL: $status_code - Success"
  else
    FAILURE=$((FAILURE + 1))
    echo "$REQUEST_URL: $status_code - Fail"
  fi
}

doSmokeTest () {
  if [[ ! "$ENDPOINT_DOMAIN_NAME" == http* ]]; then
    ENDPOINT_DOMAIN_NAME="https://$ENDPOINT_DOMAIN_NAME"
  fi

  for path in "${PATHS[@]}"
  do
    doCurl 200
  done

  path=/fhir/v0/r4/CoverageEligibilityResponse?patient=$PATIENT
  doCurl 200 $TOKEN
  path=/fhir/v0/r4/CoverageEligibilityResponse?patient=$PATIENT
  doCurl 401 "BADTOKEN"
  path=/fhir/v0/r4/CoverageEligibilityResponse?patient=123NOTME
  doCurl 403 $TOKEN

  TOTAL=$((SUCCESS + FAILURE))

  echo " TOTAL: $TOTAL | SUCCESS: $SUCCESS | FAILURE: $FAILURE "

  if [[ $FAILURE -gt 0 ]]; then
    exit 1
  fi
}

doRegressionTest() {
  doSmokeTest
}

ARGS=$(getopt -n $(basename ${0}) \
    -l "endpoint-domain-name:,environment:,token:,patient:,help" \
    -o "d:e:t:p:h" -- "$@")
[ $? != 0 ] && usage
eval set -- "$ARGS"
while true
do
  case "$1" in
    -d|--endpoint-domain-name) ENDPOINT_DOMAIN_NAME=$2;;
    -e|--environment) ENVIRONMENT=$2;;
    -t|--token) TOKEN=$2;;
    -p|--patient) PATIENT=$2;;
    -h|--help) usage '
 __________________
 |< Hey! Listen! >|
 ------------------
 .`.         .`.
 |  \       /  |
 `.  \     /  .`
   `. \___/ .`
     /     \

     .\_ _/.
    `..` `..`
    ';;
    --) shift;break;;
  esac
  shift;
done

if [[ -z "$ENDPOINT_DOMAIN_NAME" || -e "$ENDPOINT_DOMAIN_NAME" ]]; then
  usage "Missing variable K8S_LOAD_BALANCER or option --endpoint-domain-name|-d."
fi

if [[ -z "$ENVIRONMENT" || -e "$ENVIRONMENT" ]]; then
  usage "Missing variable K8S_ENVIRONMENT or option --environment|-e."
fi

if [[ -z "$TOKEN" || -e "$TOKEN" ]]; then
  usage "Missing variable TOKEN or option --token|-t."
fi

if [[ -z "$PATIENT" || -e "$PATIENT" ]]; then
  usage "Missing variable PATIENT or option --patient|-p."
fi

[ $# == 0 ] && usage "No command specified"
COMMAND=$1
shift

case "$COMMAND" in
  s|smoke-test) doSmokeTest;;
  r|regression-test) doRegressionTest;;
  *) usage "Unknown command: $COMMAND";;
esac

exit 0
