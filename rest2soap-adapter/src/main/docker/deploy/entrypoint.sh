#!/usr/bin/env bash

export APP_HOME="/opt/app_root"
echo "== User: "
id

echo "== Work directory: "
pwd

source printEnv.sh

echo "== Java Version:"
java -version

echo "== Starting application"
exec java -jar ./app.jar
