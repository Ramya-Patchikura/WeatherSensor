FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD WeatherSensor_Boot.jar WeatherSensor_Boot.jar 
RUN sh -c 'touch /WeatherSensor_Boot.jar '
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /WeatherSensor_Boot.jar .jar" ]
