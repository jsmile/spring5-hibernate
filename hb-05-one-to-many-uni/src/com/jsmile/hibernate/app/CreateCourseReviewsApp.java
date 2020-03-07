package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;
import com.jsmile.hibernate.entity.Review;

public class CreateCourseReviewsApp
{

	public static void main( String[] args )
	{
		// create SessionFactory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Instructor.class )
																	.addAnnotatedClass( InstructorDetail.class )
																	.addAnnotatedClass( Course.class )
																	.addAnnotatedClass( Review.class )
																	.buildSessionFactory();
		// get Session
		Session session = factory.getCurrentSession();
		
		try 
		{
			// begin transaction
			session.beginTransaction();

			// create a course
			Course course = new Course( "Pacman - How to Score One Millian Points." );
			// add some reviews
			course.addReview( new Review( "Great Course ... Good Luck!" ) );
			course.addReview( new Review( "Cool course. It's helpful." ) );
			course.addReview( new Review( "Too low level. Too detail." ) );
			// Execute Query : save the course and leverage the cascade all
			System.out.println( "\nSaving the Course ..." );
			session.save( course );
			System.out.println( course );
			System.out.println( course.getReviews() );
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println( "\nDeleted sucessfully" );
		}
		catch( Exception e ) { e.getCause(); }
		finally 
		{
			// close session
			session.close();
			// close factory
			factory.close();
		}

	}

}
