FROM bellsoft/liberica-native-image-kit-container:jdk-21-nik-23-glibc AS builder

WORKDIR /build

COPY . /build

RUN ./mvnw -DskipTests -Pnative native:compile

FROM bellsoft/alpaquita-linux-base:stream-glibc

COPY --from=builder /build/target/identity-service .

ENTRYPOINT ["/identity-service"]
