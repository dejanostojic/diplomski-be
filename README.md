# ps-climbers-server
Server application for software system for supporting climbing competition.

## How to run

1. Execute "mvn clean package" in root of the repository
2. Execute "java -jar target/climbers-backend-single-module-1.0-SNAPSHOT.jar" from the root of the repository

### Change db settings
In order to change db setting use following options:
* Change default configuration in source code: src/main/resources/application.properties and execute steps 1 and 2,3
* For first execution generate schema and initial data
    *spring.jpa.generate-ddl=false
    * spring.jpa.hibernate.ddl-auto=none
    * spring.datasource.initialization-mode=always
    * Execute "java -jar target/climbers-backend-single-module-1.0-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://localhost:3306/ps_climbers_docker --spring.jpa.generate-ddl=false spring.jpa.hibernate.ddl-auto=none --spring.datasource.initialization-mode=always"
* For any subsequent executions run "java -jar target/climbers-backend-single-module-1.0-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://localhost:3306/ps_climbers_docker" 

### Run in docker
* Run docker-compose up from the root of the project to run db, be and fe application 
* It uses images deployed on docker hub)
    * https://hub.docker.com/repository/docker/dejanostojic/diplomski-fe
    * https://hub.docker.com/repository/docker/dejanostojic/diplomski-be

## Swagger ui
http://diplomski.x3m.link:8081/swagger-ui.html (or localhost if you run locally)

## Default user / pass: student / student

##  Documentation
Documentation for the project can be found [here](https://fonbgacrs-my.sharepoint.com/:w:/g/personal/do20090246_student_fon_bg_ac_rs/EYqGcUJZDwpLm5SBVUwCRJwBro4hG2Oj4lpAxwkJQUf4hw?e=laQtoR)

   
