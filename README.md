# Car Rental

- Focalizado en el desarrollo de generacion de BBDD con FLYWAY sobre BBDD Postresql.
- Desarrollo de persistencia usando Hibernate para la generacion de las entidades.
- Generacion de entidades DTO y API usando la herramienta swagger mediante modelado en archivo YAML.
- Realizado de tests usando Mockito


Despliegue:

- Instalar Postgresql en la maquina, configuracion:
    Puerto 5432
    Usuario --> postgresql
    Contraseña --> admin
- Primera ejecucion lanzando un mvn clean install con el profile "flyway" para la generacion de la BBDD usando los scripts definidos en /resources/flyway/db-scripts
 
