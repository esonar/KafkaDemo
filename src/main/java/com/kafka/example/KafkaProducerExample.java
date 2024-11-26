package com.kafka.example;
import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 1; i <= 5; i++) {
            Student student = new Student(i, "Student_" + i);
            producer.send(new ProducerRecord<>("students", String.valueOf(student.id), student.toString()));
            System.out.println("Sent: " + student);
        }
        producer.close();
    }
}
