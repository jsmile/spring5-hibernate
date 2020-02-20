package com.jsmile.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 * In the case of prototypes, 
 * configured destruction lifecycle callbacks are not called.
 * 
 * 
 * */
@Component
@Scope( "prototype" )
public class SwimCoach implements ICoach, DisposableBean
{
	@Autowired
	@Qualifier( "RESTFortunService" )			// 첫 2자 이상 대문자인 경우의 default component ID 는 class 명 그자체임.
	private IFortuneService fortuneService;
	
	// .properties dependency injection
	@Value( "${foo.email}" )
	private String email;
	
	@Value( "${foo.org}" )
	private String org;
	
	
	public String getEmail() { return email; }

	public String getOrg() { return org; }

	@Override
	public String getDailyWorkout()
	{
		
		return "Practice 1km free style swimming.";
	}

	@Override
	public String getDailyFortune()
	{
		return "You are a world champion swimmer.";
	}

	
	// init method after constructor : if sdk is higer than 9, 
	@PostConstruct
	public void doStartup() { System.out.println( "TennisCoach doStartup()." ); }
	// prototype scope bean's clean method instead of @PreDestroy  
	@Override
	public void destroy() throws Exception
	{
		System.out.println( "Protype Scope Spring Bean destory()." );
	}
	
}
