FROM eclipse-temurin:17-jdk-alpine
ENV SPRING_DATA_MONGODB_URI="mongodb+srv://bicco:QotahFGnMMxhEkI2@cluster0.wswlhu9.mongodb.net/ChefLink?retryWrites=true&w=majority"
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
