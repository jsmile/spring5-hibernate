package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;
import com.jsmile.hibernate.entity.Review;

public class ReadCourseReviewsApp
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
			
			// execute query
			int theId = 11;
			Course course = session.get( Course.class, theId );
			// display the course
			System.out.println( "\nCourse : " + course );
			// display the course reviews
			System.out.println( "Course Reviews : " + course.getReviews() );
			
			// commit transaction
			session.getTransaction().commit();
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
