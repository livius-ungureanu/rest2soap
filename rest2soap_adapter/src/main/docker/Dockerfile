#FROM baseimages.bin.t-mobile.at/java/java-openjdk17:latest
FROM eclipse-temurin:17-jdk

ENV APP_NAME=@countries-adapter-ms-docker-image-name@ \
    ARTEFACT_URL=@project.build.finalName@.jar \
    APP_HOME="/opt/app_root"

USER 0

RUN mkdir -p $APP_HOME/logs $APP_HOME/tmp $APP_HOME/sec

COPY deploy/* $APP_HOME/


RUN echo "Using ARTEFACT_URL: $ARTEFACT_URL"
ADD $ARTEFACT_URL $APP_HOME/app.jar

RUN chgrp -R 0 $APP_HOME && \
    chmod -R g=u $APP_HOME && \
    chmod +x $APP_HOME/app.jar && \
    chmod +x $APP_HOME/*.sh

RUN echo $APP_HOME && ls -altr $APP_HOME

WORKDIR $APP_HOME

EXPOSE @server-port@

# ENTRYPOINT ["sleep", "infinity"] # for debugging if entrypoint fails
ENTRYPOINT ["./entrypoint.sh"]

