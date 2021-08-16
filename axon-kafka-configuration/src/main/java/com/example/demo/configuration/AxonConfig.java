package com.example.demo.configuration;

import org.axonframework.extensions.kafka.KafkaProperties;
import org.axonframework.extensions.kafka.eventhandling.producer.ConfirmationMode;
import org.axonframework.extensions.kafka.eventhandling.producer.DefaultProducerFactory;
import org.axonframework.extensions.kafka.eventhandling.producer.ProducerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    @Bean
    ProducerFactory<?, ?> producerFactory(KafkaProperties kafkaProperties) {
        return DefaultProducerFactory.builder()
                .configuration(kafkaProperties.buildProducerProperties()).producerCacheSize(10_000)
                .confirmationMode(ConfirmationMode.WAIT_FOR_ACK).build();
    }
}
