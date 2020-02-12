package com.jsmile.springdemo;

public class CraketCoach implements ICoach
{
	// dependency field
	private IFortuneService fortuneService;
	// literal value injection
	private String email;
	private String team;
	
	public CraketCoach() {}

	// Setter Injection
	public void setFortuneService( IFortuneService _fortuneService )
	{
		this.fortuneService = _fortuneService;
		System.out.println( "Craket Coach : setter injection." );
	}
	
	public void setEmail( String _email )
	{
		email = _email;
		System.out.println( "Craket Coach email : literal value injection." );
	}
	
	public void setTeam( String _team )
	{
		System.out.println( "Craket Coach time : literal value injection." );
		team = _team;
	}
	
	public String getEmail()
	{
		return email;
	}

	public String getTeam()
	{
		return team;
	}

	@Override
	public String getDailyWorkout()
	{
		return "practice of fast pitching for an 1 hour.";
	}

	@Override
	public String getDailyFortune()
	{
		return this.fortuneService.getFortune();
	}

}
