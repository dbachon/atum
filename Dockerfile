FROM gradle:jdk13 AS build
COPY . /build
WORKDIR /build
RUN gradle asemblate

FROM openjdk:12-jdk-alpine AS final
COPY --from=build /build/build/libs/*.jar /app/
WORKDIR /app
CMD  java -jar $(ls)
EXPOSE 8080