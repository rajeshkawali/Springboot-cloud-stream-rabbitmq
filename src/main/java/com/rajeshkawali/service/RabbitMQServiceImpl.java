package com.rajeshkawali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeshkawali.producer.RabbitMQProducer;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@Service
public class RabbitMQServiceImpl implements RabbitMQService {

	public static final String CLASS_NAME = RabbitMQServiceImpl.class.getName();

	@Autowired
	private RabbitMQProducer rabbitMQProducer;

	@Override
	public void processMessage(String data) throws Exception {
		String _function = ".processMessage()";
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			rabbitMQProducer.rabbitMqMessagePublisher(data);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while process a message: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
	}

}
