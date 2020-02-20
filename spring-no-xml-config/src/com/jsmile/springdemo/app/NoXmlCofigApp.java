package com.jsmile.springdemo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsmile.springdemo.ICoach;
import com.jsmile.springdemo.TaichCoach;
import com.jsmile.springdemo.config.SportsConfig;

public class NoXmlCofigApp
{

	public static void main( String[] args )
	{
		// read Spring Config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( SportsConfig.class );
		
		// get beans
		ICoach taichCoach = context.getBean( "taichCoach", ICoach.class );										// for only parent method call
		TaichCoach detailCoach = (TaichCoach)context.getBean( "taichCoach", ICoach.class ); 	// for child method call
		
		// method calls of beans
		System.out.println( taichCoach.getDailyWorkout() );
		System.out.println( taichCoach.getDailyFortune() );
		System.out.println( "################ Detail Coach ###############" );
		System.out.println( "Email : " + detailCoach.getEmail() );
		System.out.println( "Org : " + detailCoach.getOrg() );
		
		// close context.
		context.close();
	}

}
