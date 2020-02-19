package com.jsmile.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortunService implements IFortuneService
{
	public RESTFortunService()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getFortuneService()
	{
		return "Good RESTFortuneService !";
	}

}
