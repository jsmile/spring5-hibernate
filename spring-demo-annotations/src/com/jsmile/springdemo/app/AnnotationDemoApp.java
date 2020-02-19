package com.jsmile.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsmile.springdemo.ICoach;

public class AnnotationDemoApp
{

	public static void main( String[] args )
	{
		// read a spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "ApplicationContext.xml" );
		// get the bean from the spring container
		ICoach theCoach = context.getBean( "thatSillyCoach", ICoach.class );		// constructor injection
		ICoach soccerCoach = context.getBean( "soccerCoach", ICoach.class );		// setter injection, soccerCoach : default Bean id
		ICoach runningCoach = context.getBean( "runningCoach", ICoach.class );	// field injection
		// call a method on the bean
		System.out.println( theCoach.getDailyWorkout() );
		System.out.println( soccerCoach.getDailyWorkout() );
		System.out.println( runningCoach.getDailyWorkout() );
		System.out.println( runningCoach.getDailyFortune() );
		// close the context.
		context.close();

	}

}
