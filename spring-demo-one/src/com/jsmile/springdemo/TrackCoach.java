package com.jsmile.springdemo;

public class TrackCoach implements ICoach
{
	// define a private dependency field
	private IFortuneService fortuneService;
	
	public TrackCoach() { }
	// difine a constructor for dependency injection
	public TrackCoach( IFortuneService _fortuneService )
	{
		this.fortuneService = _fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout()
	{
		return "Run a hard 5km.";
	}

	@Override
	public String getDailyFortune()
	{
		// user my fortuneService
		return this.fortuneService.getFortune();
	}

}
