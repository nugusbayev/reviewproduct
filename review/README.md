# Demo Review service

### Used Technologies
* KeyCloak - for authorization purposes. User should first authenticate in KeyCloak and obtain JWT token. But /api/v1/phone/** endpoints are not secured, as those are potentially provide public information. So JWT token needed only to book and return phones.
* PostgreSQL - stores data 
* RestAPI - provides interface to interact with service
* SpringBoot - main framework
* Redis - for caching, to increase performance of  review service and to reduce load on pg
* Liquibase - to manage database migrations
* JPARepository - to make database requests
* SWAGGER - to document API