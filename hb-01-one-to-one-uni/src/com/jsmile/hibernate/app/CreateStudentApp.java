package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

public class CreateStudentApp
{

	public static void main( String[] args )
	{
		// create session factory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Student.class )
																	.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		// use the session object
		try 
		{
			System.out.println( "Creating a new object..." );

			// create a student object
			Student student = new Student( "Paul3", "Wall", "paul3@luv2code.com" );
//			student.setId( "0001" );
			// start a transaction
			session.beginTransaction();
			// save the student object
			session.save( student );
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println( "Done!" );
			
		} 
		finally 
		{
			factory.close();
		}

	}

}
