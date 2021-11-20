FROM openjdk:11

COPY target/merge-sort-case-*.jar /opt/merge-sort-case.jar

CMD ["java", "-Xmx256M", "-jar", "/opt/merge-sort-case.jar"]
