FROM openjdk:8
EXPOSE 8080
ADD ./build/libs/yonetim.jar yonetim.jar
ENTRYPOINT ["java","-jar","/yonetim.jar"]