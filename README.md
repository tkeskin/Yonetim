# Yönetim Uygulaması
- Başvuru yapılır --> Cevap verilir --> Cevap Onaylanır --> Cevap kullanıcıya gönderilir.

# Teknolojiler
- Java,Spring Boot,MVC,JPA,Microservices
- Template Engine --> Thymeleaf,Bootstrap
- Build Tools --> Maven(change to gradle)
- ORM --> Hibernate,Envers
- DB --> Mysql
- Application Server --> Tomcat
- Log --> Elasticsearch, Logstash, Kibana
- Test --> Mockito
- added checkstyle,pmd,findBugs
- Agile tool --> Scrumy

# How to Dockerize Spring Boot Application

# Build Docker Image
$ docker build -t yonetim .

# Check Docker Image
$ docker image ls

# Run Docker Image
$ docker run -p 8080:8080 yonetim

# Özet
- docker run -d -p 3306:3306 --name=mysql-server --env="MYSQL_ROOT_PASSWORD=root123" --env="MYSQL_DATABASE=yonetim" mysql
- ./gradlew clean build && docker build -t yonetim .
- docker run --name yonetimCont -d --link mysql:db -p 8080:8080 yonetim