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

public class LazyFetchJoinApp
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
			// HSQL( Fetch Join )
			int theId = 1;
			Query<Instructor> query = 
					session.createQuery( 
							"SELECT i FROM Instructor i"
							+ " JOIN FETCH i.courses"
							+ " WHERE i.id=:theInstructorId"
							, Instructor.class 
					);
			// set parameter on query
			query.setParameter( "theInstructorId", theId );
			// execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println( "\nJOIN FETCH Instrutor : " + instructor );
			
			// commit transaction
			session.getTransaction().commit();
			
			// Close Session
			session.close();

			// 	After Closing Session, display courses
			System.out.println( "\nJOIN FETCH Courses : " + instructor.getCourses() );
		}
		catch( Exception e ) { e.getCause(); }
		finally 
		{
			// close factory
			factory.close();
		}

	}

}
