package com.deliveryBoy.app.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryBoy.app.config.KafkaTopicsConstants;

@Service
public class KafkaService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public boolean updateLocation(String Location) {
		this.kafkaTemplate.send(KafkaTopicsConstants.UPDATE_LOCATION.name(),Location);
		logger.info("Location Updated");
		return true;
		
	}
}
