FROM eclipse-temurin:21
VOLUME /tmp
ARG JAR_FILE=build/libs/*SNAPSHOT.jar

RUN mkdir /opt/app
COPY ${JAR_FILE} /opt/app/japp.jar
#COPY japp.jar /opt/app
EXPOSE 8080

CMD ["java", "-jar", "/opt/app/japp.jar"]