FROM adoptopenjdk/openjdk11
MAINTAINER Dien Tran <trandien04@gmail.com>
VOLUME ["/tmp", "/tmp"]
EXPOSE 8081
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF-8 -XX:-TieredCompilation -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:+UseStringDeduplication -XX:HeapDumpPath=/tmp
ADD target/shop-service-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
