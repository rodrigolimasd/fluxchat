# Fluxpay [![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/rodrigolimasd/fluxpay/blob/master/LICENSE)
This API for making credit card payments through a gateway.
Stripe is used as payment gateway

It is a REST API built with JAVA 11 + Spring Boot + PostgreSQL + Flyway + OpenFeing + SQS + Docker + ECS + Terraform.

NewRelic was also configured for monitoring.

Sonarqube to analyze the quality of the Code.

Configured an API Gateway on AWS

And Cloudwatch for API log monitoring

The pipeline was configured in Github Actions

### Project building 👨‍🔧 ...

## Getting Started

### Prerequisites

To use the database, you will need to have PostgreSQL installed and running on your machine on the default port (5432)

### Installing

**Cloning the Repository**
````
$ git clone https://github.com/rodrigolimasd/fluxpay.git
$ cd fluxpay
````
### Running the Development environment

**Running with Maven**

With Database running and the environment properly configured, you can now run the server:

**Running API**

```
$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

To run the tests use the following command

**Running the tests**

```
$ mvn clean test
```

**Swagger** Endpoint: http://localhost:8090/swagger-ui.html

## Contributing

E-mail: rodrigolimasd@gmail.com

Connect with me at [LinkedIn](https://www.linkedin.com/in/rodrigolimasd/)

Thank you!
