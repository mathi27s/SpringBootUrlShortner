FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true


FROM openjdk:8
COPY --from=build /usr/src/app/target/shorten-url.jar /usr/src/app/shorten-url.jar
ADD target/shorten-url.jar shorten-url.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/usr/src/app/shorten-url.jar"]