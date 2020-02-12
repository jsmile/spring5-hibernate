package com.jsmile.springdemo;

public class HappyFortuneService implements IFortuneService
{

	@Override
	public String getFortune()
	{
		return "Today is a your happy Day !.";
	}

}
