FROM openjdk:11

COPY target/merge-sort-case-*.jar /opt/merge-sort-case.jar
RUN mkdir /opt/input
COPY input/example.csv /opt/input

WORKDIR /opt

CMD ["java", "-Xmx256M", "-jar", "merge-sort-case.jar"]
