# nc_educ_base
Base spring-boot application with preconfigured database connection, ORM, logging and deployment.

## Quick start

### 1. Clone repository on a local machine

    git clone https://github.com/swdovg/nc_educ_base.git

### 2. Setup java 17 if needed and check if it was installed correctly

    java -version

### 3. Build application with maven

     .\mvnw.cmd install

### 4. Run application

    java -jar .\target\project-artifact-0.0.1-SNAPSHOT.jar

### 5. Ensure application is running

Navigate to localhost:8082/healthCheck/status and check if it has UP status


## Database connection configuration

### 1.Database connection configuration

install and run desired database instance using docker or in any other way.

### 2. Set up datasource properties

All you need to set it up is to fill in next properties in config/application.properties according 
to your database configuration. By default, postgres is configured.

    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.datasource.driver-class-name=org.postgresql.Driver

### 3. Enable database initialization on startup

In config/application.properties uncomment property:
    
    spring.sql.init.mode=always

During startup application will create sample table 'clients' using src/main/resources/schema.sql file
and populate it with test data from src/main/resources/data.sql

### 4. Ensure database connection established and ORM initialized

Start application and navigate to localhost:8082/api/clientManagement/client/1. 
It should return client model jSON retrieved from database.

If data was successfully initialized on the next application start it may throw an exception.

    org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "clients_pkey"

To prevent this you need either drop table and reinitialize it or comment property below
    
    # Disables sql data initialization 
    #spring.sql.init.mode=always

## Deployment in Heroku
TBD
