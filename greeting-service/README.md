# Introduction

This is a simple RESTful greeting service.

## Test procedure

This service is configured to run on random port.
You may run multiple greet-service by:

    cd greeting-service
    mvn spring-boot:run

Then you can check if all service instances are registered
in the eureka registry by [visiting this url][1] with
your favorite browser.

[1]: http://localhost:8761/
    
