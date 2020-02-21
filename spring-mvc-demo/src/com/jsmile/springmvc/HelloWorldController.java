package com.jsmile.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController
{
	@RequestMapping( "/show-form" )
	public String showForm() 
	{
		return "hellowworld-form";
	}
	
	@RequestMapping( "/process-form" )
	public String processForm() 
	{
		return "helloworld";
	}
	
	@RequestMapping( "process-form-two" )
	public String precessFormTwo( HttpServletRequest _request, Model _model ) 
	{
		
		// read the request parameter from Html Form
		String theName = _request.getParameter( "studentName" );
		// create message
		String message = "Hi, " + theName;
		// add message to the model 
		_model.addAttribute( "message", message );
		
		return "helloworld";
	}
	
}
