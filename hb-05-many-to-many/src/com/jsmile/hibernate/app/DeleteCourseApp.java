package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;
import com.jsmile.hibernate.entity.Review;
import com.jsmile.hibernate.entity.Student;

public class DeleteCourseApp
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
																	.addAnnotatedClass( Student.class )
																	.buildSessionFactory();
		// get Session
		Session session = factory.getCurrentSession();
		
		try 
		{
			// begin transaction
			session.beginTransaction();
			
			// get the object from DB( Course )
			int theCourse = 10;
			Course course = session.get( Course.class, theCourse );
			System.out.println( "\nLoaded Course : " + course );
			System.out.println( "Courses : " + course.getStudents() );
			
			// execute query( Delete : Only Course not Student ) 
			System.out.println( "\nDeleting course : " + course );
			session.delete( course );
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println( "\nDelete completely !" );
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
