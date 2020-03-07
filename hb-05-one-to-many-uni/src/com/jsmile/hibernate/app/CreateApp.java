package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Course;
import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;


public class CreateApp
{

	public static void main( String[] args )
	{
		// create session factory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Instructor.class )
																	.addAnnotatedClass( InstructorDetail.class )
																	.addAnnotatedClass( Course.class )
																	.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		// use the session object
		try 
		{
			System.out.println( "Creating a new object..." );

			// create the needed object
/*			
			Instructor instructor = new Instructor( "Jane", "Alisa", "jane@luv2code.com" );
			InstructorDetail detail = new InstructorDetail( 
					"http://www.luv2code.com/youtube", "Luv 2 code !!!" );
*/			
			Instructor instructor = new Instructor( "Madhu", "Patel", "madhu@luv2code.com" );
			InstructorDetail detail = new InstructorDetail( 
					"http://www.youtube.com", "Guitar" );
			// associate the objects
			instructor.setInstructorDetail( detail );
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor object
			// 
			// Note : this will ALSO save the detail object
			// 				because of CascadeType.All
			session.save( instructor );
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println( "Saving instrutor Done!" );
			
		} 
		finally 
		{
			factory.close();
		}

	}

}
