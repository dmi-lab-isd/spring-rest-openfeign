FROM openjdk:11 
WORKDIR /app
COPY target/server-0.0.1-SNAPSHOT.jar /app
ENV SERVER_PORT 8081
EXPOSE $SERVER_PORT
CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar" ]
