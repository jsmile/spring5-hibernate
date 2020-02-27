package com.jsmile.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Customer
{
	private String firstName;
	
	@NotNull( message="필수 입력사항입니다." )
	@Size( min=1, message="1글자 이상 입력해야 합니다." )
	private String lastName;
	
	@NotNull( message="필수 입력사항입니다." )
	@Min( value=0, message="최소 0 보다 큰 값이어야 합니다.")
	@Max( value=10, message="최대 10 보다 작은 값이어야 합니다.")
	private Integer freePasses;		// Integer : Validation 검사 시 String 변환이 필요하기 때문.
	
	@Pattern( regexp="^[a-zA-Z0-9]{5}", message="우편번호는 5글자 입니다.")
	private String postalCode;
	
	
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

	public Integer getFreePasses() { return freePasses; }
	public void setFreePasses( Integer _freePasses ) { freePasses = _freePasses; }

	public String getPostalCode() { return postalCode; }
	public void setPostalCode( String _postalCode ) { postalCode = _postalCode; }	

	
}
