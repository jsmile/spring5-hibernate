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
	String FirstName;
	
	@Column( name="last_name" )
	String LastName;
	
	@Column( name="email" )
	String Email;
	
	
	public Student() { }

	public Student( String _firstName, String _lastName, String _email )
	{
		FirstName = _firstName;
		LastName = _lastName;
		Email = _email;
	}


	public int getId() { return id; }
	public void setId( int _id ) { id = _id; }

	public String getFirstName() { return FirstName; }
	public void setFirstName( String _firstName ) { FirstName = _firstName; }

	public String getLastName() { return LastName; }
	public void setLastName( String _lastName ) { LastName = _lastName; }

	public String getEmail(){ return Email; }
	public void setEmail( String _email ) { Email = _email; }

	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
	}	
	

}
