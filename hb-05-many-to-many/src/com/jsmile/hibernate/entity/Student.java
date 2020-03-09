package com.jsmile.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table( name="student" )
public class Student
{
	//1) Create implementation of org.hibernate.id.IdentifierGenerator
	//2) Override the method : public Serializable generate() 
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	@Column( name="id" )
	private int id;
	
	@Column( name="first_name" )
	private String firstName;
	
	@Column( name="last_name" )
	private String lastName;
	
	@Column( name="email" )
	private String email;
	
	@ManyToMany( 
			fetch=FetchType.LAZY
			, cascade= 
				{
						CascadeType.DETACH, CascadeType.MERGE 
						, CascadeType.PERSIST, CascadeType.REFRESH 
				} 
	)
	@JoinTable(
			name="course_student"
			, joinColumns=@JoinColumn( name="student_id" )
			, inverseJoinColumns=@JoinColumn( name="course_id" )			
	)
	private List<Course> courses;
	
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

	public List<Course> getCourses() { return courses; }
	public void setCourses( List<Course> _courses )
	{
		courses = _courses;
	}

/*	
	// add a relationship method
	public boolean addCourse( Course _course ) 
	{
		if( this.courses == null ) { this.courses = new ArrayList<>(); }
		if( _course == null ) return false;
		
		this.courses.add( _course );
		return true;
	}
*/	
	
	// toString()
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email + "]";
	}	
	

}
