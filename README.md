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

**Running with Gradle**

**Start database**
```
docker-compose up -d
```

**Running API**

```
$ ./gradlew bootRun
```

To run the tests use the following command

**Running the tests**

```
$ ./gradlew clean test
```

### Consuming the API

**Creating a payment**
```
$ curl --location --request POST 'http://localhost:8080/api/v1/payments' \
--header 'Content-Type: application/json' \
--data-raw '{
    "amount": 100.10,
    "currency": "BRL",
    "description": "credit card payment test",
    "card": {
        "cardHolderName":"holder name",
        "cardNumber":"123**123",
        "expirationMonth": 1,
        "expirationYear": 2030,
        "cvc": 123
    }
}'
```
**Getting a payment**
```
curl --location 'localhost:8080/api/v1/payments/30793a39-c068-4331-80d6-f1a9707e8b92'
```

## Contributing

E-mail: rodrigolimasd@gmail.com

Connect with me at [LinkedIn](https://www.linkedin.com/in/rodrigolimasd/)

Thank you!
