FROM openjdk:8
WORKDIR '/app'
ADD target/job-0.0.1-SNAPSHOT.jar job-0.0.1-SNAPSHOT.jar
EXPOSE 8086
COPY . .
ENTRYPOINT ["java", "-jar", "job-0.0.1-SNAPSHOT.jar"]