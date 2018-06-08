package com.revature.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void send(String topic, String payload) {
		kafkaTemplate.send(topic, payload);
	}

}
