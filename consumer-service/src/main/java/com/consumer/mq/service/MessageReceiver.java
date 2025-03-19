package com.consumer.mq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.consumer.mq.exception.InvalidSalaryException;
import com.consumer.mq.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageReceiver {
	@RabbitListener(queues = "gcore.queue")
	public void recievedMessage(Employee employee) throws InvalidSalaryException {
		log.info("Received Message From RabbitMQ: " + employee);
		if (employee.getSalary() < 0) {
			throw new InvalidSalaryException();
		}
	}
}