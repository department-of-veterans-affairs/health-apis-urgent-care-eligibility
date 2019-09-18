#!/usr/bin/env bash

set -o pipefail

#For running our test suite (currently for lab validation/stress testing only)
[ -z "$TEST_BASE_DIR" ] && TEST_BASE_DIR=/test-suite
cd $TEST_BASE_DIR
MAIN_JAR=$(find -maxdepth 1 -name "urgent-care-tests-*.jar" -a -not -name "urgent-care-tests-*-tests.jar")
TESTS_JAR=$(find -maxdepth 1 -name "urgent-care-tests-*-tests.jar")
WEB_DRIVER_PROPERTIES="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver -Dwebdriver.chrome.headless=true"
SYSTEM_PROPERTIES=$WEB_DRIVER_PROPERTIES
EXCLUDE_CATEGORY=
INCLUDE_CATEGORY=


#For doing our simplistic smoke and regression tests
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


# Command to make LAB OAuth Test work
# shm-size needs to be increased to 1g.
# shm is just shared temporary file storage on Unix.  I don't know why this script runs out while others dont...

# docker run --rm --init --shm-size="1g" --network=host
#     --env K8S_ENVIRONMENT=lab
#     --env-file staging.testvars
#     vasdvp/health-apis-urgent-care-tests:latest ol

# OR

# docker run --rm --init --shm-size="1g" --network=host
#     --env-file staging.testvars
#     vasdvp/health-apis-urgent-care-tests:latest ol
#     --environment=lab

# The first one matches more in line of how DQ does it.  The second option matches how our regression/smoke tests work.

usage() {
  cat <<EOF
  Commands
    list-tests
    list-categories
    test [--include-category <category>] [--exclude-category <category>] [-Dkey=value] <name> [name] [...]
    smoke-test [--endpoint-domain-name|-d <endpoint>] [--environment|-e <env>] [--token|-t <token>] [--patient|-p <ICN>]
    regression-test [--endpoint-domain-name|-d <endpoint>] [--environment|-e <env>] [--token|-t <token>] [--patient|-p <ICN>]
    oauth-lab-test [--environment|-e <env>]

  Example
    smoke-test
      --endpoint-domain-name localhost
      --environment qa
      --token 123ME
      --patient ME


$1
EOF
exit 1
}

#### Start of test suite runner commands ####
defaultTest() {
  # Our only test is for Oauth right now. We can default to integration tests whenever we have some
  doListTests | grep 'Oauth'
}

# This feels like overkill for our single test, but ignoring all this output feels more important as our suite grows
doTest() {
  local tests="$@"
  [ -z "$tests" ] && tests=$(defaultTest)
  local filter
  [ -n "$EXCLUDE_CATEGORY" ] && filter+=" --filter=org.junit.experimental.categories.ExcludeCategories=$EXCLUDE_CATEGORY"
  [ -n "$INCLUDE_CATEGORY" ] && filter+=" --filter=org.junit.experimental.categories.IncludeCategories=$INCLUDE_CATEGORY"
  local noise="org.junit"
  noise+="|groovy.lang.Meta"
  noise+="|io.restassured.filter"
  noise+="|io.restassured.internal"
  noise+="|java.lang.reflect"
  noise+="|java.net"
  noise+="|org.apache.http"
  noise+="|org.codehaus.groovy"
  noise+="|sun.reflect"
  java -cp "$(pwd)/*" $SYSTEM_PROPERTIES org.junit.runner.JUnitCore $filter $tests \
    | grep -vE "^	at ($noise)"

  # Exit on failure otherwise let other actions run.
  [ $? != 0 ] && exit 1
}

doListTests() {
  jar -tf $TESTS_JAR \
    | grep -E '(IT|Test)\.class' \
    | sed 's/\.class//' \
    | tr / . \
    | sort
}

doListCategories() {
  # There are no urgent care specific categories if you're comparing this to dq
  jar -tf $MAIN_JAR \
    | grep -E 'gov/va/api/health/sentinel/categories/.*\.class' \
    | sed 's/\.class//' \
    | tr / . \
    | sort
}



checkVariablesForAutomation() {
  # Check out required deployment variables and urgent care specific variables.
  for param in "USER_PASSWORD" "CLIENT_ID" "CLIENT_SECRET" \
    "REDIRECT_URL" "AUD" "STATE" "BASE_URL" "REQUEST_MODE" \
    "REQUEST_TYPE" "SKIP_TWO_FACTOR_AUTHENTICATION"; do
    [ -z ${!param} ] && usage "Variable $param must be specified."
  done
}

setupForAutomation() {
  checkVariablesForAutomation

  SYSTEM_PROPERTIES="$WEB_DRIVER_PROPERTIES \
    -Dva-oauth-robot.user-password=$USER_PASSWORD \
    -Dva-oauth-robot.client-id=$CLIENT_ID \
    -Dva-oauth-robot.client-secret=$CLIENT_SECRET \
    -Dva-oauth-robot.redirect-url=$REDIRECT_URL \
    -Dva-oauth-robot.aud=$AUD \
    -Dva-oauth-robot.state=$STATE \
    -Dva-oauth-robot.base-url=$BASE_URL \
    -Dva-oauth-robot.credentials-mode=$REQUEST_MODE \
    -Dva-oauth-robot.credentials-type=$REQUEST_TYPE \
    -Dva-oauth-robot.skip-two-factor-authentication=$SKIP_TWO_FACTOR_AUTHENTICATION"
}

doLabOauthTest(){
  setupForAutomation

  INCLUDE_CATEGORY=gov.va.api.health.sentinel.categories.Manual
  doTest
}

#### Start of smoke and regression tests ####
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
    -l "endpoint-domain-name:,environment:,token:,patient:,exclude-category:,include-category:,help" \
    -o "d:e:t:p:hD:x:i:" -- "$@")
[ $? != 0 ] && usage
eval set -- "$ARGS"
while true
do
  case "$1" in
    -d|--endpoint-domain-name) ENDPOINT_DOMAIN_NAME=$2;;
    -e|--environment) ENVIRONMENT=$2;;
    -D) SYSTEM_PROPERTIES+=" -D$2";;
    -t|--token) TOKEN=$2;;
    -p|--patient) PATIENT=$2;;
    -x|--exclude-category) EXCLUDE_CATEGORY=$2;;
    -i|--include-category) INCLUDE_CATEGORY=$2;;
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

[ $# == 0 ] && usage "No command specified"
COMMAND=$1
shift

case "$COMMAND" in
  t|test) doTest $@;;
  lc|list-categories) doListCategories;;
  lt|list-tests) doListTests;;
  s|smoke-test) doSmokeTest;;
  r|regression-test) doRegressionTest;;
  ol|oauth-lab-test) doLabOauthTest;;
  *) usage "Unknown command: $COMMAND";;
esac

exit 0
