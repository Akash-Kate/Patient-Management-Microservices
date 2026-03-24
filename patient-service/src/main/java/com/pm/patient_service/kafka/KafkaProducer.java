package com.pm.patient_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

	
	// This is how we define our mesg types how we are sending messeges to topics from this producer
	// event format
	private final KafkaTemplate<String, byte[]> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	} 
	
	
	
	
	
	
	
	
}
