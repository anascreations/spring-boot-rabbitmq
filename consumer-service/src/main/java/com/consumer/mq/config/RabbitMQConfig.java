package com.consumer.mq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	@Bean
	Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
