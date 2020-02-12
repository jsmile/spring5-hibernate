package com.jsmile.springdemo;

public class MyApp
{

	public static void main( String[] args )
	{
		// object 생성
		ICoach theCoach = new TrackCoach();
		// object 이용
		System.out.println( theCoach.getDailyWorkout() );		

	}

}
