# Native image build: GraalVM 25 (required by Spring Boot 4 AOT/native).
FROM ghcr.io/graalvm/native-image-community:25 AS build
# gradlew needs xargs
RUN microdnf install -y findutils && microdnf clean all
WORKDIR /app
COPY . .
RUN --mount=type=cache,target=/root/.gradle ./gradlew nativeCompile --no-daemon

FROM gcr.io/distroless/base-debian12:nonroot
# Kamal requires service=<service> (deploy/apps/fullstack-with-spring/config/deploy.yml).
LABEL service="fullstack-with-spring"
COPY --from=build /app/build/native/nativeCompile/fullstack-demo /app/fullstack-demo
EXPOSE 8080
ENTRYPOINT ["/app/fullstack-demo"]
