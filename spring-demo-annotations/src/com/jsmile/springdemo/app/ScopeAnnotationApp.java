package com.jsmile.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsmile.springdemo.ICoach;
import com.jsmile.springdemo.SwimCoach;
import com.jsmile.springdemo.TennisCoach;


/*
 *  custom coding for destroying prototype beans
 *  1) Create a custom bean processor.
 *  2) The prototype scoped beans MUST implement the DisposableBean interface.
 *  3) - To provide the destroy() method
 * */
public class ScopeAnnotationApp
{

	public static void main( String[] args )
	{
		// load Spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		// Create Bean
		//	Singleton Scope
		TennisCoach theCoach = (TennisCoach)context.getBean( "thatSillyCoach", ICoach.class ); 
		TennisCoach coach = (TennisCoach)context.getBean( "thatSillyCoach", ICoach.class );
		//	Prototype Scope
		SwimCoach swimCoach = (SwimCoach)context.getBean( "swimCoach", ICoach.class );
		SwimCoach swimCoachPrototyle = (SwimCoach)context.getBean( "swimCoach", ICoach.class );
		
		// call the method of Bean
		boolean bSingleton = ( theCoach == coach );
		System.out.println( "Singleton Scope : " + bSingleton );
		System.out.println( "theCoach is : " + theCoach );
		System.out.println( "coach is : " + coach );		
		System.out.println( "###################################" );
		boolean bPrototype = ( swimCoach == swimCoachPrototyle );
		System.out.println( "Prototype Scope : " + bPrototype );
		System.out.println( "swimCoach is : "  + swimCoach );
		System.out.println( "swimCoachPrototype is : " + swimCoachPrototyle );
		
		// close context
		context.close();

	}

}
