# i2i-Academy-Event-Driven-Architecture-with-Apache-Kafka

# Event-Driven Architecture with Apache Kafka

## Overview

This project demonstrates the basic principles of Event-Driven Architecture (EDA) using Apache Kafka. A Java Producer publishes custom Java objects to a Kafka topic, while a Java Consumer subscribes to the same topic and prints the received objects to the console.


## Technologies Used

- Java 21
- Apache Kafka 4.3.1
- Docker
- Maven
- Jackson Databind
- VS Code
- Google Cloud VM (Debian 13)

---

## Event-Driven Architecture (EDA)

Event-Driven Architecture is a software architecture in which components communicate by producing and consuming events.

Benefits include:

- Loose coupling
- High scalability
- Better fault tolerance
- Real-time communication
- Easier integration between services

---

## Local Deployment

### Prerequisites

- Java 21
- Maven
- Docker Desktop

### Start Kafka

```bash
docker run -d \
--name kafka-eda \
-p 9092:9092 \
apache/kafka:4.3.1
```

### Create Kafka Topic

```bash
docker exec -it kafka-eda \
/opt/kafka/bin/kafka-topics.sh \
--create \
--topic student-events \
--bootstrap-server localhost:9092
```

### Compile Project

```bash
mvn clean compile
```

### Run Consumer

```bash
mvn exec:java -Dexec.mainClass=com.example.kafkaeda.ConsumerApp
```

### Run Producer

```bash
mvn exec:java -Dexec.mainClass=com.example.kafkaeda.ProducerApp
```

---

## Expected Output

Producer

```
Message sent successfully!
Topic: student-events
Partition: 0
Offset: 0
```

Consumer

```
Message received!
Java Object:
StudentEvent{id=1,...}
```

---

# Cloud Deployment (Google Cloud VM)

The project was also deployed on a Google Cloud Virtual Machine running Debian 13.

### Environment

- Google Cloud Compute Engine
- Debian 13
- Java 21
- Maven 3.9
- Docker Engine
- Apache Kafka 4.3.1



This project successfully demonstrates the fundamentals of Event-Driven Architecture using Apache Kafka. A Java Producer publishes custom Java objects to Kafka, and a Java Consumer receives and processes those objects. The implementation was tested locally using Docker and prepared for deployment on a Google Cloud Virtual Machine.
