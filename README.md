# Custom Metrics Toy Project

This is a toy project to practice custom metrics using Spring Boot and Micrometer.

# How to Run
1. `./docker/docker-compose up -d`
2. Call the API
````
curl -X POST localhost:8080/order?productId=1
````
3. Check Prometheus and Grafana
````
http://localhost:9090
````