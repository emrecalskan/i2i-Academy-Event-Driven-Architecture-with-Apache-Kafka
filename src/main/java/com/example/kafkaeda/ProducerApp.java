package com.example.kafkaeda;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.producer.KafkaProducer;

import org.apache.kafka.clients.producer.ProducerRecord;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerApp {

    private static final String TOPIC_NAME = "student-events";

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        ObjectMapper objectMapper = new ObjectMapper();

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {

            StudentEvent event = new StudentEvent(
                    1,
                    "Emre Caliskan",
                    "HOMEWORK_STARTED",
                    "Kafka Producer sent a custom Java object."
            );

            String eventJson = objectMapper.writeValueAsString(event);

            ProducerRecord<String, String> record =
                    new ProducerRecord<>(TOPIC_NAME, String.valueOf(event.getId()), eventJson);

            producer.send(record, (RecordMetadata metadata, Exception exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully!");
                    System.out.println("Topic: " + metadata.topic());
                    System.out.println("Partition: " + metadata.partition());
                    System.out.println("Offset: " + metadata.offset());
                    System.out.println("Data: " + eventJson);
                } else {
                    System.out.println("Error while sending message:");
                    exception.printStackTrace();
                }
            });

            producer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}