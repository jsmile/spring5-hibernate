package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;

public class CreateCourseApp
{

	public static void main( String[] args )
	{
		// create SessionFactory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Instructor.class )
																	.addAnnotatedClass( InstructorDetail.class )
																	.addAnnotatedClass( Course.class )
																	.buildSessionFactory();
		// get Session
		Session session = factory.getCurrentSession();
		
		try 
		{
			// begin transaction
			session.beginTransaction();
			// get needed object
			int theId = 1;
			Instructor instructor = session.get( Instructor.class, theId );
			Course course1 = new Course( "Air Guitar - Ulimate Guide" );
			Course course2 = new Course( "The Pinball Master Class" );
			// execute query : 
			//	save the courses
			session.save( course1 );
			session.save( course2 );
			//	make relationship with course
			instructor.addCourse( course1 );
			instructor.addCourse( course2 );			
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
