# Goal: demo a rest2soap adapter where a openapi rest json target layer is translated based on a wsdl layer


---
## Build
`mvn clean install`

## Build image
`mvn clean package -Pdocker -DskipTests`

## Run image
`docker run -it -p 8081:8081 localhost/countries-adapter-ms:0.0.1`
