package com.jsmile.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name="student" )
public class Student
{
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	@Column( name="id" )
	int id;
	
	@Column( name="first_name" )
	String firstName;
	
	@Column( name="last_name" )
	String lastName;
	
	@Column( name="email" )
	String email;
	
	
	public Student() { }

	public Student( String _firstName, String _lastName, String _email )
	{
		firstName = _firstName;
		lastName = _lastName;
		email = _email;
	}


	public int getId() { return id; }
	public void setId( int _id ) { id = _id; }

	public String getFirstName() { return firstName; }
	public void setFirstName( String _firstName ) { firstName = _firstName; }

	public String getLastName() { return lastName; }
	public void setLastName( String _lastName ) { lastName = _lastName; }

	public String getEmail(){ return email; }
	public void setEmail( String _email ) { email = _email; }

	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email + "]";
	}	
	

}
