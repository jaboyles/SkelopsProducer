package com.revature.beans;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//This sends a message, not about the money
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	
	public void sendTrex(TRex trex) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(trex);
		this.rabbitTemplate.convertAndSend("trex", json);
	}
}
