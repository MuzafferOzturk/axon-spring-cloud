package com.example.demo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProjectionStream {
    String TOPIC_NAME = "spring-cloud-exchange";

    @Input(TOPIC_NAME)
    SubscribableChannel topicSubscribeChannel();
}
