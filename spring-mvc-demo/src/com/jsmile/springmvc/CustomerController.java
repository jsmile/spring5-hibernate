package com.jsmile.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/customer" )
public class CustomerController
{
	// InitBinder : pre-process each web request to controller
	@InitBinder
	public void initBinder( WebDataBinder _dataBinder ) 
	{
		StringTrimmerEditor trimer = new StringTrimmerEditor( true );
		
		_dataBinder.registerCustomEditor( String.class, trimer );
	}
	
	@RequestMapping( "/show-form" )
	public String showForm( Model _model ) 
	{
		_model.addAttribute( "customer", new Customer() );
		
		return "customer-form";
	}
	
	@RequestMapping( "/process-form" )
	public String processForm( 
									@Valid @ModelAttribute( "customer" ) Customer _customer
									, BindingResult _bindingResult ) 
	{
		// error code 인 codes [typeMismatch.customer.freePasses, ... ]을  
		// messages.properties 에  정의하여 처리
		System.out.println( "BindingResult : " + _bindingResult );
		
		if( _bindingResult.hasErrors() ) { return "customer-form"; }
		else { return "customer-confirmation"; }
	}

} // end of CustomerController
