package com.revature.beans;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//This sends a message, not about the money
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 1000L)
	public void sendTrex(TRex trex) {
		this.rabbitTemplate.convertAndSend("trex", trex);
	}
}
