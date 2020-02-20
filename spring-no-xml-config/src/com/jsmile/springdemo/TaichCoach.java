package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaichCoach implements ICoach
{
	private IFortuneService fortuneService;
	
	@Value( "${foo.email}" )
	private String email;
	@Value( "${foo.org}" )
	private String org;
	
	public TaichCoach( IFortuneService _fortuneService )
	{
		this.fortuneService = _fortuneService;
	}
	
	public String getEmail() { return email; }
	public String getOrg() { return org; }

	@Override
	public String getDailyWorkout()
	{
		return "Practice the basic form of Chen's Taich for an 30 minutes.";
	}

	@Override
	public String getDailyFortune()
	{
		return this.fortuneService.getFortuneService();
	}

}
