# Build
`mvn clean install`

# Build image
`mvn clean package -Pdocker -DskipTests`

# Run image
`docker run -it -p 8080:8080 localhost/soap-countries-web-service:0.0.1`