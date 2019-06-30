# Yönetim Uygulaması
- Başvuru yapılır --> Cevap verilir --> Cevap kullanıcıya gönderilir.

# Teknolojiler
- Java,Spring Boot,MVC,JPA,Microservices
- Template Engine --> Thymeleaf,Bootstrap
- Build Tools --> Maven(change to gradle)
- ORM --> Hibernate,Envers
- DB --> Mysql
- Application Server --> Tomcat
- Log --> Elasticsearch, Logstash, Kibana
- Test --> Mockito
- Agile tool --> Scrumy

# How to Dockerize Spring Boot Application

# Build Docker Image
$ docker build -t yonetim .

# Check Docker Image
$ docker image ls

# Run Docker Image
$ docker run -p 9090:8080 yonetim

# Özet
1- docker run --name=mysql -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=yonetim -d mysql
2 - ./gradlew clean build && docker build -t yonetim .
3 - docker run --name yonetimCont -d --link mysql:db -p 8080:8080 yonetim