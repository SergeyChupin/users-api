FROM bellsoft/liberica-openjre-alpine:11
RUN mkdir -p /app/
ADD target/users-api-*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]