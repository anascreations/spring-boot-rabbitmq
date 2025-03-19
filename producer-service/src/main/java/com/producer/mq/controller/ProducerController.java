package com.producer.mq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.mq.model.Employee;
import com.producer.mq.service.MessageSender;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("rabbitmq")
@RequiredArgsConstructor
public class ProducerController {

	private final MessageSender rabbitMQSender;

	@GetMapping(value = "producer")
	public String producer(@RequestParam String empName, @RequestParam String empId, @RequestParam int salary) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setSalary(salary);
		rabbitMQSender.send(emp);
		return "Message sent to the RabbitMQ Gcore Successfully";
	}
}
