package com.jsmile.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements IFortuneService
{

	// define a default constructor
	public HappyFortuneService()
	{
		System.out.println( "HappyFortuneService : default Constructor" );
	}


	@Override
	public String getFortuneService()
	{
		return "It's a lucky Day !";
	}
	
}
