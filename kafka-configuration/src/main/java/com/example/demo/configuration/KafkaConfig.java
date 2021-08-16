package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaderMapper;
import org.springframework.kafka.support.SimpleKafkaHeaderMapper;

import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public KafkaHeaderMapper kafkaBinderHeaderMapper() {
        SimpleKafkaHeaderMapper headerMapper = new SimpleKafkaHeaderMapper();
        headerMapper.setRawMappedHeaders(Map.of(
                "axon-message-type", true
        ));
        return headerMapper;
    }
}
