/**
 * 
 */
package com.project.camel.camel_application.component;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

/**
 * @author emmanuelraj
 * Using BeanComponent producing template 
 * i.e sending the msg particular method using bean
 *  
 */
public class BeanComponent {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		
		
		
		/**
		 * in BeanComponent 
		   init the service class
		   init SimpleRegistry 
		   put registry map (param1, param2);
		   param1 ---> reference of service class as string 
		   param2 --->	reference of service class	   
		 */
		
		ClassComponent classComponent = new ClassComponent();
		
		
		SimpleRegistry simpleRegistry = new SimpleRegistry();
		
		
		simpleRegistry.put("classComponent", classComponent);
		
		
		
		//init camelContext setRegistry as param
		CamelContext context = new DefaultCamelContext(simpleRegistry);
	
		
		
		//add routes into context
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("direct:start")
				.to("bean:classComponent?method=doSomething");
				
			}
		});
		
		//start context
		context.start();

		
		
		//init ProducerTemplate
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		
		
		//send msg from producerTemplate
		producerTemplate.sendBody("direct:start", "Hello Bean Producer");
	}

}
