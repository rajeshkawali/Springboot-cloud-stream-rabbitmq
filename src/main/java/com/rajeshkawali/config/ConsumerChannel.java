
package com.rajeshkawali.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author Rajesh_Kawali
 *
 */
@Component
public interface ConsumerChannel {

	public static final String CONSUME_MESSAGE = "consumeMessage";

	@Input(CONSUME_MESSAGE)
	public SubscribableChannel getConsumerChannel();

}