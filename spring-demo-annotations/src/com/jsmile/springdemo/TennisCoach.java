package com.jsmile.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 *  default component ID : Class 명의 앞자리를 소문자로 변경
 * */
@Component( "thatSillyCoach" )
@Scope( "singleton" )
public class TennisCoach implements ICoach
{
	//@Autowired	
	private IFortuneService fortuneService;
	
	public TennisCoach()
	{
		System.out.println( "Bean Creation for Qualifier annotation." );
	}
	
/*
	// dependency Contructor injection by annotation : 
	@Autowired	
	public TennisCoach( IFortuneService _fortuneService ) 
	{
		this.fortuneService = _fortuneService;
		System.out.println( "dependency Contructor injection by annotation." );
	}
*/	
	
	// dependency Qualifier Contructor injection by annotation : 
	@Autowired	
	public TennisCoach( @Qualifier( "happyFortuneService" )IFortuneService _fortuneService ) 
	{
		this.fortuneService = _fortuneService;
		System.out.println( "dependency Constructor injection by annotation." );
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
	
	// init method after constructor : if sdk is higer than 9, 
	@PostConstruct
	public void doStartup() { System.out.println( "TennisCoach doStartup()." ); }
	// clean method before destory;
	@PreDestroy
	public void doCleanup() { System.out.println( "TenishCoach doCleanup()" ); }

}
