package com.jsmile.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesAnnotationApp
{

	public static void main( String[] args )
	{
		// load spring context configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
		// create bean
		SwimCoach theCoach = (SwimCoach)context.getBean( "swimCoach", ICoach.class );
		// call method 
		System.out.println( "### .properties Annotaion ###" );
		System.out.println( theCoach.getEmail() );
		System.out.println( theCoach.getOrg() );		
		
		// close the context
		context.close();

	}

}
