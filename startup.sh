#!/bin/sh

java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/administrator-micro-service/target/administrator-micro-service-0.0.1-SNAPSHOT.jar &

java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/borrower-micro-service/target/borrower-micro-service-0.0.1-SNAPSHOT.jar &

java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/librarian-micro-service/target/librarian-micro-service-0.0.1-SNAPSHOT.jar &

java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/gateway/target/gateway-0.0.1-SNAPSHOT.jar &

java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &
