package com.jsmile.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	// 4) create constructors
	public InstructorDetail() { }
	public InstructorDetail( String _youtubeChannel, String _hobby )
	{
		youtubeChannel = _youtubeChannel;
		hobby = _hobby;
	}
	
	// 5) generate the getter and setter
	public int getId(){ return id; }
	public void setId( int _id ) { id = _id; }
	
	public String getYoutubeChannel() { return youtubeChannel; }
	public void setYoutubeChannel( String _youtubeChannel )
	{
		youtubeChannel = _youtubeChannel;
	}
	
	public String getHobby() { return hobby; }
	public void setHobby( String _hobby ) { hobby = _hobby; }
	
	
	// 6) generate toString()
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
