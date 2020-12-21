FROM openjdk:11 
WORKDIR /app
COPY target/client-0.0.1-SNAPSHOT.jar /app
ENV SERVER_PORT 8080
EXPOSE $SERVER_PORT
CMD ["java", "-jar", "client-0.0.1-SNAPSHOT.jar" ]
