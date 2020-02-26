package com.jsmile.springmvc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

public class Student
{
	private String firstName;
	private String lastName;
	
	private String country;
//	private LinkedHashMap<String, String> countryOptions;	 no .properties 사용 시
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	
	public Student() 
	{
/*  .properties 를 사용하지 않을 때 사용 
		this.countryOptions = new LinkedHashMap<>();
		countryOptions.put("KR", "Korea");
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States of America");
*/	
	}
	
	public String getFirstName() { return this.firstName; }
	public void setFirstName( String _firstName ) { this.firstName = _firstName; }
	
	public String getLastName() { return this.lastName; }
	public void setLastName( String _lastName ) { this.lastName = _lastName; }

	public String getCountry() { return country; } 
	public void setCountry( String _country ) { country = _country; }

/*	
	public LinkedHashMap<String, String> getCountryOptions() { return countryOptions; }
	public void setCountryOptions( LinkedHashMap<String, String> _countryOptions ) 
	{ 
		countryOptions = _countryOptions; 
	}
*/	

	public String getFavoriteLanguage() { return favoriteLanguage; }
	public void setFavoriteLanguage( String _favoriteLanguage )
	{
		favoriteLanguage = _favoriteLanguage;
	}	
	

	public String[] getOperatingSystems() { return operatingSystems; }
	public void setOperatingSystems( String[] _operatingSystems ) { operatingSystems = _operatingSystems; }	
	
}
