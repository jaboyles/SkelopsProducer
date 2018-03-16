package com.revature.beans;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//This sends a message, not about the money
@Component
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	
	public void sendTrex(TRex trex) {
		this.rabbitTemplate.convertAndSend("trex", trex);
	}
}
