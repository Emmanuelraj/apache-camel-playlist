/**
 * 
 */
package com.project.camel.camel_application.activemq;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author emmanuelraj
 * Fetch Msg ActiveMQ to Consumer messages
 */
public class ActiveMQToConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		//init CamelContext 
		CamelContext context = new DefaultCamelContext();
		
		//add routes into context
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception 
			{
				
				System.out.println("configure method");
				//Below direct  for producer + seda for consumer is mandatory
                from("activemq:queue:first_queue")   
               .to("seda:end");
				
			}
		});
		
		
		//start context
		context.start();
		
		//init consumerTemplate
		ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
		
		
		//
		String customerMsg = consumerTemplate.receiveBody("seda:end",String.class);

		
		System.out.println("customerMsg ----->"+customerMsg);

	}

}
