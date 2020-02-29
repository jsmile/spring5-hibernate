package com.jsmile.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{
	private String[] coursePrefixes;

	@Override
	public void initialize( CourseCode _courseCode )
	{
		this.coursePrefixes = _courseCode.value();		
	}

	// constraint rule for validation
	@Override
	public boolean isValid( String _courseCode, ConstraintValidatorContext _constraintValidatorContext )
	{
		boolean result = false;
		
		if( _courseCode == null | _courseCode.length() < 1 ) { return result = false; }
		
		for(String prefix : coursePrefixes ) 
		{
			result = _courseCode.startsWith( prefix ); 
			if( result ) break;
		}
		
		return result;		
	}

}
