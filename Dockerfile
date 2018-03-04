FROM java:8-jre
MAINTAINER Anton Pavlov <anton.it.pavlov@gmail.com>
ADD ./target/iwanttoeat.jar /app/
CMD ["java", "-jar", "/app/iwanttoeat.jar"]
EXPOSE 8080