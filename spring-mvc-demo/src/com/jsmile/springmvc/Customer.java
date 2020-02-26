package com.jsmile.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Customer
{
	private String firstName;
	
	@NotNull( message="필수 입력사항입니다." )
	@Size( min=1, message="1글자 이상 입력해야 합니다." )
	private String lastName;
	
	public Customer() { }

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName( String _firstName )
	{
		firstName = _firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
	public void setLastName( String _lastName )
	{
		lastName = _lastName;
	}
	
	
}
