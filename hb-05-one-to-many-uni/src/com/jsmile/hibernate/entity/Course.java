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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="course" )
public class Course
{
	// 1) define fields
	// 2) create constructors
	// 3) create getters and setters
	// 4) annotate the fields
	// 5) create toString()
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	
	@Column( name="title" )
	private String title;
	
	// no delete cascade 
	@ManyToOne( 
			cascade= 
			{ 
					CascadeType.DETACH, CascadeType.MERGE 
					, CascadeType.PERSIST, CascadeType.REFRESH 
			} )
	@JoinColumn( name="instructor_id" )
	private Instructor instructor;
	
	@OneToMany( 
			fetch=FetchType.LAZY
			, cascade=CascadeType.ALL 
	)
	@JoinColumn( name="course_id" )
	private List<Review> reviews;
	
	public Course() { }
	public Course( String _title ) { title = _title; }

	public int getId() { return id; } 
	public void setId( int _id ) { id = _id; }
	
	public String getTitle() { return title; }
	public void setTitle( String _title ) { title = _title; }
	
	public Instructor getInstructor() { return instructor; }
	public void setInstructor( Instructor _instructor )
	{
		instructor = _instructor;
	}
	
	public List<Review> getReviews() { return reviews; }
	public void setReviews( List<Review> _reviews )
	{
		reviews = _reviews;
	}
	
	// Add a Relationship Method
	public boolean addReview( Review _review ) 
	{
		if( this.reviews == null ) { this.reviews = new ArrayList<Review>(); }
		
		if( _review == null ) return false;
		this.reviews.add( _review );
		
		return true;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "Course [id=" );
		builder.append( id );
		builder.append( ", title=" );
		builder.append( title );
		builder.append( "]" );
		return builder.toString();
	}
	

}
