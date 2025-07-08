#!/usr/bin/env bash

echo ""
echo " ============================================================== "
echo " == Environment Variables: "
echo ""
echo "  ENVIRONMENT = $ENVIRONMENT"
echo "  APP_HOME = $APP_HOME"
echo "  APP_NAME = $APP_NAME"
echo "  SERVICE_PORT = $SERVICE_PORT"
echo "  BASE_URL = $BASE_URL"
echo "  LOGGING_SERVER = $LOGGING_SERVER"
echo "  LOGGING_PORT_TCP = $LOGGING_PORT_TCP"
echo "  LOGGING_PORT_UDP = $LOGGING_PORT_UDP"
echo "  STATISTICS_SERVER = $STATISTICS_SERVER"
echo "  STATISTICS_PORT_TCP = $STATISTICS_PORT_TCP"
echo "  STATISTICS_PORT_UDP = $STATISTICS_PORT_UDP"
echo ""
echo "  Application URL = https://$APP_NAME.$ENVIRONMENT.$BASE_URL/"
echo ""
echo " ============================================================== "
echo ""

echo ""
echo " Creating $APP_HOME/node.properties file..."
echo ""
echo "environment=$ENVIRONMENT" >$APP_HOME/node.properties
echo "instance=$APP_NAME" >>$APP_HOME/node.properties
echo "node=$POD_NAME" >>$APP_HOME/node.properties
echo "metrics.statsd.server.hostname=$STATISTICS_SERVER" >>$APP_HOME/node.properties
echo "metrics.statsd.server.port.tcp=$STATISTICS_PORT_TCP" >>$APP_HOME/node.properties
echo "metrics.statsd.server.port.udp=$STATISTICS_PORT_UDP" >>$APP_HOME/node.properties
echo "logging.server.hostname=$LOGGING_SERVER" >>$APP_HOME/node.properties
echo "logging.server.port.tcp=$LOGGING_PORT_TCP" >>$APP_HOME/node.properties
echo "logging.server.port.udp=$LOGGING_PORT_TCP" >>$APP_HOME/node.properties

echo "------------------------------------------------------------------------"
cat $APP_HOME/node.properties
echo "------------------------------------------------------------------------"
echo ""
