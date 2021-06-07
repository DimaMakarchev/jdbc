FROM openjdk:11
EXPOSE 8080
ADD target/jdbc.jar jdbc.jar
#ENV TZ Europe/Moscow
COPY  . target/
ENTRYPOINT ["java","-jar","/jdbc.jar"]
