# Webflux-Graalvm---Base

Este proyecto contiene los plugins para las metricas con graphana
analisis de codigo con sonarqube
mensajeria con kafka
optimizacion de modelos con protobuf
protocolo de comunicacion Rest y Websocket
documentacion de metodos Rest con Swagger

Tienes dos controladores, uno para peticiones REST con Json y otro para peticiones SOAP con xml,
    ambos controladores hacen uso del mismo servicio y mueven el mismo objeto.
    
Para visualizar los metodos disponibles: http://localhost:8080/webjars/swagger-ui/index.html

Generate coverage y enviar a sonar:

./gradlew test jacocoTestReport sonar