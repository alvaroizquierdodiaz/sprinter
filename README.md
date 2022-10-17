## Sprinter Challenge

Proyecto Spring Boot en java 1.8 que tenga un endpoint de tipo restful,  al
que se le pase un json con un artículo y sus características y que se pueda
hacer lo típico (crear, modificar, eliminar, obtener, etc). Puntos a tener en
cuenta:
- Separación de paquetes 
- Gestión de excepciones 
- Uso de bd h2 en memoria 
- Test del repositorio, servicio y controlador

A partir de aquí se valorará:
- Caché para las peticiones 
- Pool de conexiones 
- Logs en la app 
- Modo y tiempo de entrega


## Manual de usuario

Hay que tener lo siguiente instalado:

- Maven
- JDK 11
- Lombok

Para poder ejecutar la aplicación hay que seguir los siguientes pasos:

- Acceder desde un terminal a la carpeta de sprinterChallenge
- Ejecutar el comando: mvn spring-boot:run
- Acceder a la URL: http://localhost:8080/swagger-ui/index.html
- Para poder probar los métodos del servicio, hay que darle al botón "Try it out" y poner los valores tal y como se indican en la documentación del servicio
- Luego pulsar en el botón "Execute"

Para poder ejecutar los test, hay que:

- Acceder desde un terminal a la carpeta de sprinterChallenge
- Ejecutar el comando: mvn test