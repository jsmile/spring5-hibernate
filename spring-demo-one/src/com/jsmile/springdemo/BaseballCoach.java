package com.jsmile.springdemo;

public class BaseballCoach implements ICoach 
{
	@Override
	public String getDailyWorkout() 
	{
		return "Spend 30 minutes on batting practice.";
	}

	@Override
	public String getDailyFortune()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
