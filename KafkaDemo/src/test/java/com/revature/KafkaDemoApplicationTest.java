package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.consumer.Receiver;
import com.revature.producer.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class KafkaDemoApplicationTest {
	
	private static final String HELLOWORLD_TOPIC = "helloworld.t";
	
	@ClassRule
	public static KafkaEmbedded embeddedKafka = 
		new KafkaEmbedded(1, true, HELLOWORLD_TOPIC);
	
	@Autowired 
	Receiver receiver;
	
	@Autowired
	Sender sender;
	
	@Test
	public void testReceive() throws Exception {
		sender.send(HELLOWORLD_TOPIC, "Hello from Spring Kafka");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}

}
