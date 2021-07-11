# shorten_url




#### Swagger url - http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/shortner-controller/

In postman please send the body with url
Example:
Body
{longurl: https://www.hackerrank.com/competitions/celebrate-pride-2021-coding-contest
}

Response you will be get a string of up to 8 characters, It is the shorten url.

When you access the local host with return response (ex: https://localhost:8080/b), it will redirect you 
to the original url in browser



To run the project, Please run following commands
1. docker build -t shorten-url .
2. docker-compose up






