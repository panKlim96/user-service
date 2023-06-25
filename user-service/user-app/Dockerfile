FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine
ARG APP_JAR_FILE="./target/user-app-0.0.1-SNAPSHOT.jar"
ENV JAVA_OPTS="-Xmx1024m -Xss512k -XX:MetaspaceSize=128m"
ENV JAVA_OPTS_ADD=""

RUN mkdir -p /apps

COPY ${APP_JAR_FILE} /apps/user-app.jar

COPY ./entrypoint.sh /apps/entrypoint.sh
RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]