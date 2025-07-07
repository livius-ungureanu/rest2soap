# Goal: create a rest2soap adapter

## Scope:
- For the moment will use just a invent rest json and wsdl interface which will be replaced with the real interfaces when available.
- create the RIM_SIM microservice that for the beginning will just adapt a rest/json request to a wsdl request and respond with rest/json.
- dockerize RIM_SIM
- create an integration test as a junit test that tests the main scenario.
  We need to  test container so that RIM_SIM  talks to the dockerized wsdl server.

## Input:
- wsdl server simulating  countries info as a dummy wsdl interface
- openapi for the RIM_SIM ( for the moment the dummy openapi countries spec)

---
## Build
`mvn clean install`

## Build image
`mvn clean package -Pdocker -DskipTests`

## Run image
`docker run -it -p 8081:8081 localhost/countries-adapter-ms:0.0.1`