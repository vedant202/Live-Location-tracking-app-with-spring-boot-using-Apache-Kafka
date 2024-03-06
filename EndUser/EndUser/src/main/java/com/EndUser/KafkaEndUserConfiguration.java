package com.EndUser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaEndUserConfiguration {
	
	@KafkaListener(topics = KafkaConstants.UPDATE_LOCATION,groupId = "group-1")
	public void updatedLocation(String value) {
		System.out.println("Updated Location :- "+value);
	}
}
