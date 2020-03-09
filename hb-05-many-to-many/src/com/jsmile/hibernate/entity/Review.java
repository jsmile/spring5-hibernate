package com.jsmile.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="review" )
public class Review
{
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	
	@Column( name="comment" )
	private String comment;
	
/*	foreign key field is optional.
	private Course course;
*/	
	
	public Review() { }
	public Review( String _comment ) { comment = _comment; }
	
	
	public int getId() { return id; }
	public void setId( int _id ) { id = _id; }
	
	public String getComment() { return comment; } 
	public void setComment( String _comment ) { comment = _comment; }

/*	
	public Course getCourse() { return course; } 
	public void setCourse( Course _course ) { course = _course; }
*/
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "Review [id=" );
		builder.append( id );
		builder.append( ", comment=" );
		builder.append( comment );
		builder.append( "]" );
		return builder.toString();
	}
	
	
}
