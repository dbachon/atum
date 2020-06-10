FROM gradle AS build
COPY . /build
WORKDIR /build
RUN gradle build

FROM openjdk:8-jdk-alpine AS final
COPY --from=build /build/build/libs/*.jar /app/
WORKDIR /app
CMD  java -jar $(ls)
EXPOSE 8080