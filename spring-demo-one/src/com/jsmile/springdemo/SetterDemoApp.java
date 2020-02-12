package com.jsmile.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp
{

	public static void main( String[] args )
	{
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		// retrieve bean from the spring context( Setter Injection )
		CraketCoach myCoach = context.getBean( "myCraketCoach", CraketCoach.class );
		// call methods on the bean
		System.out.println( myCoach.getDailyFortune() );
		System.out.println( myCoach.getEmail() );
		System.out.println( myCoach.getTeam() );
		// close the context
		context.close();

	}

}
