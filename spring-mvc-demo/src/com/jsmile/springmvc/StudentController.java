package com.jsmile.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/student" )
public class StudentController
{
	@RequestMapping( "/show-form" )
	public String shwoForm( Model _model ) 
	{
		// create a student object
		Student theStudent = new Student();
		// add it to the model
		_model.addAttribute( "student", theStudent );
		
		return "student-form";
	}
	
	@RequestMapping( "/process-form" )
	public String processForm( @ModelAttribute( "student" ) Student _theStudent ) 
	{
		System.out.println( "theStuednt : " + _theStudent.getFirstName() + " " + _theStudent.getLastName() );
		for ( String item : _theStudent.getOperatingSystems() ) 
		{
			System.out.println( "operatingSystems : " + item );	
		}
		
		
		return "student-confirmation";
	}

}
