/**
 * 
 */
package com.project.camel.camel_application;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author emmanuelraj
 * 
 * This program purpose is sending file producer from file to activemq server 
 *
 */

public class FileToActiveMQ
{
    public static void main(String[] args) throws Exception
    {
    	
    	//init
    	CamelContext context = new DefaultCamelContext();
    	
    	 //connectionFactory 	jms
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    	
    	//now add jms component in context
    	context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
   
    	
    	 //add routes in context
        context.addRoutes(new RouteBuilder() {
			
        	
           
                 	
			@Override
			public void configure() throws Exception 
			{
				
	        	from("file:input_box?noop=true")
	        	.to("activemq:queue:first_queue");
	         	
			}
			
			
		});
    	
        
        while(true)
        {
        	context.start();
        }
	}
}
