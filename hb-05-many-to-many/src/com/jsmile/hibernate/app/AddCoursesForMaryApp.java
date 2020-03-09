package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;
import com.jsmile.hibernate.entity.Review;
import com.jsmile.hibernate.entity.Student;

public class AddCoursesForMaryApp
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
			int theStudentId = 2;
			Student student = session.get( Student.class, theStudentId );
			System.out.println( "\nLoaded Student : " + student );
			
			Course course1 = new Course( "Rubik's Cube - How to Speed Cube." );
			Course course2 = new Course( "Atari - Game Development." );
			
			// make a relationship
			course1.addStudent( student );
			course2.addStudent( student );
			
			// execute query 
			System.out.println( "\nSaving Courses ..." );
			session.save( course1 );
			session.save( course2 );
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println( "\nCompletely Saved : " + student.getCourses() );
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
