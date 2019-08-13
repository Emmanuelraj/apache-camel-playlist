/**
 * 
 */
package com.project.camel.camel_application.component;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author emmanuelraj
 *
 */
public class CallingMethodUsingClassComponent 
{
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		//init camelContext 
		CamelContext context = new DefaultCamelContext();
		
		//add routes into camelContext
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception 
			{
			   from("direct:start")
			   //calling classComponent class method doSomething
			   .to("class:com.project.camel.camel_application.component.ClassComponent?method=doSomething");
			}
		});
		
		
		//start context
		context.start();
		
		
		//init create ConsumerTemplate
		ProducerTemplate producerTemplate  =context.createProducerTemplate();
		
		//
		producerTemplate.sendBody("direct:start","Hello");
		
		
	}

}
