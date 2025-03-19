package com.producer.mq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.producer.mq.model.Employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageSender {

	private final AmqpTemplate amqpTemplate;

	public void send(Employee employee) {
		amqpTemplate.convertAndSend("gcore-direct-exchange", "gcore", employee);
		log.info("Send msg = " + employee);
	}
}