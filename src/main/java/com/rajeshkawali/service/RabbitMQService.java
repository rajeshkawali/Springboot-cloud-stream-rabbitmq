package com.rajeshkawali.service;
/**
 * @author Rajesh_Kawali
 *
 */
public interface RabbitMQService {

	public void processMessage(String xmlData) throws Exception;

}