package com.location.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.location.controller.MessageController;

@Configuration
@EnableKafka
public class KafkaListenerConfig {

	@Autowired
	private MessageController messageController;

	@KafkaListener(topics = "vehicle_location", group = "grp-vehicle")
	public void listen(String message) {

		System.out.println("Received Messasge: " + message);
		
		SseEmitter latestEm = messageController.getLatestEmitter();
				
		try {
			latestEm.send(message);
		} catch (IOException e) {
			latestEm.completeWithError(e);
		}

	}
}
