package com.jsmile.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.jsmile.springdemo.HappyFortuneService;
import com.jsmile.springdemo.ICoach;
import com.jsmile.springdemo.IFortuneService;
import com.jsmile.springdemo.TaichCoach;


/*
 *  No XML configuration in spring
 *  1) define method to expose bean
 *  2) java file에 @Configuration 추가
 *  3) java file에 @ComponentScan 추가( option )
 *  4) or define bean
 *  5) read spring configuration class
 *  6) Retrieve bean from Spring container
 * */
@Configuration
//@ComponentScan( "com.jsmile.springdemo" )
@PropertySource( "classpath:/com/jsmile/springdemo/resource/sport.properties" )
public class SportsConfig
{
/*
	// In Spring 4.2 and lower, add support to resolve ${...} properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
*/	
	
	// define bean : Method name is the Bean ID 
	@Bean
	public IFortuneService happyFortuneService() { return new HappyFortuneService(); }

	// define bean and dependency injection( Constructor Injection )
	@Bean
	public ICoach taichCoach() 
	{
		// Method is used as a parameter for dependency injection     
		return new TaichCoach( happyFortuneService() );
	}
	
}
