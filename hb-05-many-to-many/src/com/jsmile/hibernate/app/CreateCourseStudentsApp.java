package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;
import com.jsmile.hibernate.entity.Review;
import com.jsmile.hibernate.entity.Student;

public class CreateCourseStudentsApp
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

			// create objects( Course & Student ) 
			Course course = new Course( "Pacman - How to Score One Millian Points." );
			Student student1 = new Student( "John", "Doe", "john@luv2code.com" );
			Student student2 = new Student( "Mary", "Public", "marry@luv2code.com" );
			
			// make a relationship
			course.addStudent( student1 );
			course.addStudent( student2 );
			
			// execute query 
			System.out.println( "\nSaving Courses ..." );
			session.save( course );
			System.out.println( "\nCompletely Saved : " + course);
			System.out.println( "\nSaving Students ..." );			
			session.save( student1 );
			session.save( student2 );
			System.out.println( "\nCompletely Saved : " + course.getStudents() );
			
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
