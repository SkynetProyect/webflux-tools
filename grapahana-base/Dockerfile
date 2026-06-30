#stage 1
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
RUN microdnf install -y findutils
COPY . .
RUN ./gradlew nativeCompile --no-daemon

#stage 2
FROM gcr.io/distroless/cc-debian12:latest
COPY --from=debian:12-slim /lib/x86_64-linux-gnu/libz.so.1 /lib/x86_64-linux-gnu/libz.so.1
COPY --from=builder /app/build/native/nativeCompile/ /app/
ENTRYPOINT ["/app/compilationTEST", "-Xmx242m", "-Xms64m"]