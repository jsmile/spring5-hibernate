package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements ICoach
{
	// field injection : setter 없이도 가능함.
	@Autowired
	private IFortuneService fortuneService;
	
	// default constructor
	public RunningCoach() { }
	
	@Override
	public String getDailyWorkout()
	{
		return "** practice a 4km running !";
	}

	@Override
	public String getDailyFortune()
	{
		System.out.println( "** It is injected by a Field Injection." );
		return this.fortuneService.getFortuneService();
	}

}
