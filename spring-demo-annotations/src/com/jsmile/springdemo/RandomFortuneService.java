package com.jsmile.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements IFortuneService
{
	// create an array of Strings
	private String[] data = 
	{
			"Welcome to my Wrold!", 
			"Today is a Lucky Day", 
			"You are a Happy Person."
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortuneService()
	{
		int index = myRandom.nextInt( data.length );
		String theFortune = data[ index ];
		
		return theFortune;
	}

}
