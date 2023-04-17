# Demo ECPN service

### Used Technologies
* KeyCloak - for authorization purposes. User should first authenticate in KeyCloak and obtain JWT token. But GET endpoints are not secured, as those are potentially provide public information.
* PostgreSQL - stores data; normally for storing high volume reviews scalable mongodb like dbs are good, but for simplicity used pg
* RestAPI - provides interface to interact with service
* RestTemplate - to make rest requests to third party services, such as adidas.com
* SpringBoot - main framework
* Redis - for caching, to increase performance of  review service and to reduce load on pg
* Liquibase - to manage database migrations
* JPARepository - to make database requests
* SWAGGER - to document API

### Entities
* Review - represents review information

### Services
* Common - module with common shared models
* Review - manages review entity, provides REST API.
* Product - aggregation service, provides REST API, collects data online from review service and adidas.com

P.S. List of predefined reviews already inserted into database during first run.

P.S.S You may use  provided docker-compose in order to run KeyCloak, PostgreSQL, Redis

P.S.S.S Firstly create realm and user in Keycloak;make request to login, apply token for authorized requests
