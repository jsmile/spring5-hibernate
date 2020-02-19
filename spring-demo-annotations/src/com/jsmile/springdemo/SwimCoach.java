package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements ICoach
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

}
