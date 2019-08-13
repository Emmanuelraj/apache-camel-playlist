
package com.project.camel.camel_application;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
/**
 * This Class example providing ProducerAndConsumerTemplate
 * Basically Producer used to send the msg
 * Consumer used to receieve the msgs
 * Author : R.Emmanuel Raj
 */
public class ProccessApacheCamel {

	/**
	 * @param args
	 */
	  public static void main( String[] args ) throws Exception
	    {
	        System.out.println( "Hello World!" );
	        
	        
	        /**
	         * Bean Config
	         * @throws Exception
	         */
	        
	      	
	        	
	        	System.out.println(" producerConsumerTemplateExample method");
	            //init camelContext
	           CamelContext context = new DefaultCamelContext();
	           //add routes in context
	           context.addRoutes(new RouteBuilder() {
	            @Override
	            public void configure() throws Exception
	            {

	                //Below direct  for producer + seda for consumer is mandatory
	                 from("direct:start")   
	               //adding Processor into  routes
	                 .process(new Processor() {
						
						public void process(Exchange exchange) throws Exception
						{
						   						
							System.out.println("add Proccessor into routes");
							
						}
					})

	                                  
	                         .to("seda:end");

	            }


	        });
	           
	           
	           
	        //start context
	           context.start();

	        //init ProducerTemplate
	        ProducerTemplate producerTemplate = context.createProducerTemplate();

	        //send msg in producer
	        //param1 endpoint & param2: msg 
	        producerTemplate.sendBody("direct:start","Hello From Producer");


	        //init ConsumerTemplate
	        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();


	        //receiveMsg
	        // (param1: to type  , param2: data type of msg going to be received)
	        String consumerMsg  = consumerTemplate.receiveBody("seda:end",String.class);

	        //Sop
	        System.out.println("consumerMsg ---->"+consumerMsg);


	    }

}
