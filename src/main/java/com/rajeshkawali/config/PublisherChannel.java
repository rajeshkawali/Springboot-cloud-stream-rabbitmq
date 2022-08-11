
package com.rajeshkawali.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author Rajesh_Kawali
 *
 */
@Component
public interface PublisherChannel {

	public static final String PUBLISH_MESSAGE = "publishMessage";

	@Output(PUBLISH_MESSAGE)
	public MessageChannel getPublisherChannel();

}