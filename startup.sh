#!/bin/sh

start_administrator() {
	java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/administrator-micro-service/target/administrator-micro-service-0.0.1-SNAPSHOT.jar &
}

start_borrower() {
	java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/borrower-micro-service/target/borrower-micro-service-0.0.1-SNAPSHOT.jar &
}

start_librarian() {
	java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/librarian-micro-service/target/librarian-micro-service-0.0.1-SNAPSHOT.jar &
}

start_eureka() {
	java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/gateway/target/gateway-0.0.1-SNAPSHOT.jar &
}

start_orchestrator() {
	java -jar /home/santiago/Dev/IdeaProjects/Training/micro-lms/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &
}

start_all() {
	start_eureka
	start_orchestrator
	start_administrator
	start_borrower
	start_librarian
}

if [ $# -eq 0 ]
	then
		start_all
		exit 0
fi

for i in $@ 
do
	eval "start_$i"
	exit 0
done	 	
