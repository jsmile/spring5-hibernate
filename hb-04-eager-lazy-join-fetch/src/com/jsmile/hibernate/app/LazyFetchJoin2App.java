package com.jsmile.hibernate.app;

import java.lang.reflect.Constructor;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;

public class LazyFetchJoin2App
{
	/**
	 *  After session closing, data can be accessed by HSQL( Join Fetch ) 
	 * */
	
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
			// HSQL : 
			int theId = 1;
			Instructor instructor = session.get( Instructor.class, theId );
			System.out.println( "\nInstructor : " + instructor );
			// commit 
			session.getTransaction().commit();
			// close session
			session.close();
			System.out.println( "Session is closed !" );
						
			
			// create a new session
			session = factory.getCurrentSession();
			System.out.println( "\nOpen a new Session !" );			
			// begin transaction
			session.beginTransaction();
			
			// HSQL( NO JOIN FETCH )
			Query<Course> query = 
					session.createQuery( 
							"SELECT c FROM Course c"
							+ " WHERE c.instructor.id=:theInstructorId"
							, Course.class 
					);
			// set parameter on query
			query.setParameter( "theInstructorId", theId );
			// execute query and get instructor
			List<Course> courseList = query.getResultList();
			
			// 	 in a NEW Session, display courses
			System.out.println( "\nCourseList : " + courseList );
		}
		catch( Exception e ) { e.getCause(); }
		finally 
		{
			// close factory
			factory.close();
		}

	}

}
