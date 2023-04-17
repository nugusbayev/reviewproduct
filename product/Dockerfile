FROM openjdk:11.0.6-jre-slim

ADD ./build/libs/*SNAPSHOT.jar /app/product-service.jar
ENV JAVA_OPTIONS "-XX:+UseContainerSupport -XX:InitialRAMPercentage=40 -XX:MaxRAMPercentage=50 -XX:MinRAMPercentage=30"
ENV JAVA_JMX ""
ENV JAVA_ARGS ""
CMD ["/bin/bash", "-c", "java -server $JAVA_OPTIONS $JAVA_JMX -jar /app/product-service.jar $JAVA_ARGS"]
