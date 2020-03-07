package com.jsmile.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.jboss.logging.Field;

// 1) annotate the class as @Entity and @Table
@Entity
@Table( name="instructor_detail" )
public class InstructorDetail
{
	// 2) define the fields
	// 3) annotate the fields with DB column names
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	
	@Column( name="youtube_channel" )
	private String youtubeChannel;
	
	@Column( name="hobby" )
	private String hobby;
	
	// 4) annotate Bidirectional relationship
	//		but only DetailInstructor row is deleted
	@OneToOne( mappedBy="instructorDetail"
							, cascade= 
								{ 
										CascadeType.DETACH, CascadeType.MERGE 
										, CascadeType.PERSIST, CascadeType.PERSIST 
										, CascadeType.REFRESH 
								} )

//	"mappedBy" tells Hibernate( 참조받는 것 : mappedBy, 참조하는 것 : joinColumn )
//	Look at the 'instructorDetail' property in the Instructor
//	Use information from the Instructor class '@JoinColumn'
//	To help find associated instructor	

//	@OneToOne( mappedBy="instructorDetail", cascade=CascadeType.ALL )	// for Bidirectional Relationship
	private Instructor instructor;
	
	// 5) create constructors
	public InstructorDetail() { }
	public InstructorDetail( String _youtubeChannel, String _hobby )
	{
		youtubeChannel = _youtubeChannel;
		hobby = _hobby;
	}
	
	// 6) generate the getter and setter
	public int getId(){ return id; }
	public void setId( int _id ) { id = _id; }
	
	public String getYoutubeChannel() { return youtubeChannel; }
	public void setYoutubeChannel( String _youtubeChannel )
	{
		youtubeChannel = _youtubeChannel;
	}
	
	public String getHobby() { return hobby; }
	public void setHobby( String _hobby ) { hobby = _hobby; }
	
	public Instructor getInstructor() { return instructor; }
	public void setInstructor( Instructor _instructor ) { instructor = _instructor; }
	
	// 7) generate toString()
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "InstructorDetail [id=" );
		builder.append( id );
		builder.append( ", youtubeChannel=" );
		builder.append( youtubeChannel );
		builder.append( ", hobby=" );
		builder.append( hobby );
		builder.append( "]" );
		return builder.toString();
	}

}
