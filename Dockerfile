FROM java:8
VOLUME /tmp
EXPOSE 8081
ADD target/climbers-backend-single-module-1.0-SNAPSHOT.jar crud.jar

# Add wait-for-it
#COPY wait-for-it.sh wait-for-it.sh
#RUN chmod +x wait-for-it.sh


ENTRYPOINT ["java","-jar","crud.jar"]
