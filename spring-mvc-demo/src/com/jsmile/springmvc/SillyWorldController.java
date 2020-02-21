package com.jsmile.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( "/silly" )
public class SillyWorldController
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
	
	@RequestMapping( "/process-form-two" )
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
	
	@RequestMapping( "/process-form-three" )
	public String precessFormThree( @RequestParam( "studentName" ) String _theName, Model _model ) 
	{
		// create message
		String message = "Hi, " + _theName;
		// add message to the model 
		_model.addAttribute( "message", message );
		
		return "helloworld";
	}
	
}
