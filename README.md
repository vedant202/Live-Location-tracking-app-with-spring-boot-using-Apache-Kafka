
Apache Kafka is a distributed streaming platform that is designed to handle real-time data feeds and provide a scalable, fault-tolerant, and high-throughput messaging system. Kafka is widely used for building real-time data pipelines and streaming applications. It was originally developed by LinkedIn and later open-sourced as an Apache Software Foundation project.

Here are some key concepts and components of Apache Kafka:

1.  **Topic:**
    
    -   A topic is a category or feed name to which records are published.
    -   Producers publish messages to topics.
    -   Consumers subscribe to topics to process the messages.
2.  **Producer:**
    
    -   A producer is responsible for publishing records to a Kafka topic.
    -   Producers push messages to Kafka topics.
3.  **Consumer:**
    
    -   A consumer subscribes to one or more topics and processes the feed of published records.
    -   Consumers pull messages from Kafka topics.
4.  **Broker:**
    
    -   Kafka brokers are servers that store the data and serve client requests.
    -   Brokers are responsible for managing topics, producers, and consumers.
5.  **Partition:**
    
    -   Topics are divided into partitions, which are the basic unit of parallelism and scalability.
    -   Each partition is an ordered and immutable sequence of records.
6.  **Offset:**
    
    -   Each message within a partition has a unique identifier called an offset.
    -   Offsets are used by consumers to keep track of the messages they have consumed.
7.  **Zookeeper:**
    
    -   Kafka uses Apache ZooKeeper for distributed coordination and management of the Kafka brokers.
    -   ZooKeeper is used for leader election, configuration management, and distributed synchronization.

Windows Terminal Command

Start ZooKeeper
>bin/zookeeper-server-start.sh config/zookeeper.properties

Start Server

>bin/kafka-server-start.sh config/server.properties
```
```
___________
Create new topic 
>bin\windows\kafka-topics.bat --create --topic user-topic --bootstrap-server localhost:9092

Produce new topic 
>bin\windows\kafka-console-producer.bat --topic user-topic --bootstrap-server localhost:9092

Consuming message
>bin\windows\kafka-console-consumer.bat --topic user-topic --from-beginning --bootstrap-server localhost:9092

## Spring Boot Producer and Consumer Configuration

Producer configuration
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer


Consumer configuration
server.port=8081
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=group-id
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

####  Producer Configuration file

@Configuration

public  class ApacheConfig {

@Bean

public NewTopic topic() {

return TopicBuilder.name(KafkaTopicsConstants.UPDATE_LOCATION.name())

.build();

}

}   
####  Consumer Configuration file
@Configuration

public  class KafkaEndUserConfiguration {

@KafkaListener(topics = KafkaConstants.UPDATE_LOCATION,groupId = "group-1")

public  void updatedLocation(String value) {

System.out.println("Updated Location :- "+value);

}

}
