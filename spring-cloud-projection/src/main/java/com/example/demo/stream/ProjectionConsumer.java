package com.example.demo.stream;

import com.example.demo.data.CreateEvent;
import com.example.demo.data.DepositeEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProjectionConsumer {

    @StreamListener(value = ProjectionStream.TOPIC_NAME, condition = "headers['axon-message-type']=='com.example.demo.data.CreateEvent'")
    public void streamTopic(CreateEvent event) {
        log.error("Create event {} ", event);
    }

    @StreamListener(value = ProjectionStream.TOPIC_NAME, condition = "headers['axon-message-type']=='com.example.demo.data.DepositeEvent'")
    public void streamTopic(DepositeEvent event) {
        log.error("Deposite event {} ", event);
    }
}
