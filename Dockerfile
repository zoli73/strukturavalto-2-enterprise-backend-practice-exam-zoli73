FROM maven:3.9.1-amazoncorretto-20@sha256:e8c7db9a9299813d23dab76871584bb411a4a85173e665f2c3acb1ae5db8bb4d AS BUILDER
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /build/src
RUN mvn package -DskipTests
FROM amazoncorretto:19-alpine@sha256:21cc27d3f3a4a79b32c060bd55576a22922a2a70bfe7a6b3a886ad8119ecc174
WORKDIR /app
RUN addgroup --system javauser
RUN adduser -S -s /bin/false -G javauser javauser
COPY --from=BUILDER build/target/train-0.0.1-SNAPSHOT.jar /app/application.jar
RUN chown -R javauser:javauser /app
EXPOSE 8080
USER javauser
CMD ["java", "-jar", "application.jar"]

# docker build -t train -f Dockerfile .
# docker run --name train -p 8080:8080 -d --rm train
