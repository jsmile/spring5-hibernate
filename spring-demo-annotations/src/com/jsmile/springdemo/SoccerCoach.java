package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements ICoach
{
	IFortuneService fortuneService;
	
	// define the default constructor
	public SoccerCoach()
	{
		System.out.println( ">> SoccerCoach is created with a Default Constructor" );
	}

	/*
	// dependency setter injection by annotation.  
	@Autowired
	public void setFortuneService( IFortuneService _fortuneService )
	{
		fortuneService = _fortuneService;
		System.out.println( ">> dependency Setter Injection by annotation" );
	}
	*/
	
	//dependency method injection by annotation. : possible to inject dependency by any method
	@Autowired
	@Qualifier( "happyFortuneService" )
	public void doAwesomeStuff( IFortuneService _fortuneService )
	{
		fortuneService = _fortuneService;
		System.out.println( ">> dependency Method Injection by annotation" );
	}	

	@Override
	public String getDailyWorkout()
	{
		return "Do a practice of lifting a ball for an hour.";
	}

	@Override
	public String getDailyFortune()
	{
		return this.fortuneService.getFortuneService();
	}


}
