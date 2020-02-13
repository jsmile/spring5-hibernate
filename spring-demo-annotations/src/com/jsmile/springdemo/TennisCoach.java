package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( "thatSillyCoach" )
public class TennisCoach implements ICoach
{
	private IFortuneService fortuneService;
	
	// dependency Contructor injection by annotation : 
	@Autowired
	public TennisCoach( IFortuneService _fortuneService ) 
	{
		this.fortuneService = _fortuneService;
		System.out.println( "dependency Contructor injection by annotation." );
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortuneService();
	}
	
	

}
