./mvnw clean package
docker build -t pruebafabio .
docker run -d -p 9090:8080  pruebafabio 
