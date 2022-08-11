
package com.rajeshkawali.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.rajeshkawali.config.ConsumerChannel;
import com.rajeshkawali.service.RabbitMQService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@EnableBinding(value = {
		ConsumerChannel.class
})
@Component
public class RabbitMQConsumer {

	public static final String CLASS_NAME = RabbitMQConsumer.class.getName();

	@Autowired
	private RabbitMQService rabbitMQService;

	@StreamListener(target = ConsumerChannel.CONSUME_MESSAGE)
    public void rabbitMqMessageListener(String data) throws Exception {
		String _function = ".rabbitMqMessageListener()"; 
		log.info(CLASS_NAME + _function + "::ENTER");
		try {
			log.info(CLASS_NAME + _function + "::data: {}", data);
			rabbitMQService.processMessage(data);
		} catch (Exception e) {
			log.error(CLASS_NAME + _function + "::Exception occurred while processing rabbitmq message: " + e);
		}
		log.info(CLASS_NAME + _function + "::EXIT");
	}
}
