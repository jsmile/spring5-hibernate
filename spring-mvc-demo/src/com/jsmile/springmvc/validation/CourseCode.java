package com.jsmile.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.jmx.support.RegistrationPolicy;

@Constraint( validatedBy = CourseCodeConstraintValidator.class )
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface CourseCode
{
	// value
//	public String value() default "LUV";  single variable	
	public String[] value() default { "LUV", "JS" };	
	// error message
	public String message() default "반드시 LUV 혹은 JS 로 시작해야 합니다.";
	// groups
	public Class<?>[] groups() default {};
	// define payloads
	public Class<? extends Payload>[] payload() default {};

}
