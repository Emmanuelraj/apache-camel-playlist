package com.project.camel.camel_application.activemq;

import java.util.Date;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Purpose: This LClass Sending Object to ActiveMQ
 */
public class ObjectToActiveMQ {

	public static void main(String[] args) throws Exception
	{
	   //init Apache  CamelContext
	 CamelContext context = new DefaultCamelContext();
	 
	 
	 //init ActiveMQConnectionFactory
	 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	 
	 
	 //now add connectionFactory Jms component
	 context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
	 
	
	 
	 
	 //addRoutes in context
	 context.addRoutes(new RouteBuilder() {
		
		@Override
		public void configure() throws Exception 
		{			
			System.out.println("configure method");
			
			from("direct:start")
        	.to("activemq:queue:first_queue");
	   			
		}
	});
	 
	 
	 
	 //start context;
	 context.start();
	 
	 
	 //create producerTemplate
	 ProducerTemplate producerTemplate = context.createProducerTemplate();
	 //sendBody
	 producerTemplate.sendBody("direct:start", new Date());
	 
	 
	
		
		
	
	}

}
