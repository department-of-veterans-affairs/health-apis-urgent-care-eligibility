FROM vasdvp/health-apis-maven:3.6-jdk-12

COPY maven/ /test-suite
RUN chmod 700 /test-suite/*sh
ENTRYPOINT ["/test-suite/entrypoint.sh"]
CMD []
