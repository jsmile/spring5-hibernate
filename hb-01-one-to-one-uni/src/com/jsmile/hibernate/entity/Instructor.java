package com.jsmile.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// 1) annotate the class as @Entity and @Table
@Entity
@Table( name="instructor" )
public class Instructor
{
	// 2) define the fields
	// 3) annotate the fields as @Id and @Column
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	
	@Column( name="first_name" )
	private String firstName;
	
	@Column( name="last_name" )	
	private String lastName;
	
	@Column( name="email" )	
	private String email;
	
	// 4) annotate the foreign key constraint
	@OneToOne( cascade=CascadeType.ALL )
	@JoinColumn( name="instructor_detail_id" )
	private InstructorDetail instructorDetail;
	

	// 5) create constructors
	public Instructor() { }
	public Instructor( String _firstName, String _lastName, String _email )
	{
		firstName = _firstName;
		lastName = _lastName;
		email = _email;
	}


	// 6) create getter and setter
	public int getId() { return id; }
	public void setId( int _id ) { id = _id; }

	public String getFirstName()	{ return firstName; }
	public void setFirstName( String _firstName )
	{
		firstName = _firstName;
	}

	public String getLastName() { return lastName; }
	public void setLastName( String _lastName ) { lastName = _lastName; }

	public String getEmail() { return email; }
	public void setEmail( String _email ) { email = _email; }

	public InstructorDetail getInstructorDetail() { return instructorDetail; }
	public void setInstructorDetail( InstructorDetail _instructorDetail )
	{
		instructorDetail = _instructorDetail;
	}
	
	
	// 7) create toString()
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "Instructor [id=" );
		builder.append( id );
		builder.append( ", firstName=" );
		builder.append( firstName );
		builder.append( ", lastName=" );
		builder.append( lastName );
		builder.append( ", email=" );
		builder.append( email );
		builder.append( ", instructorDetail=" );
		builder.append( instructorDetail );
		builder.append( "]" );
		return builder.toString();
	}

}
