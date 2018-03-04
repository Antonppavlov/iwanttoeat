FROM java:8-jre
MAINTAINER Anton Pavlov <anton.it.pavlov@gmail.com>
ADD ./target/calculation-food-products-back.jar /app/
CMD ["java", "-jar", "/app/iwanttoeat.jar"]
EXPOSE 8080