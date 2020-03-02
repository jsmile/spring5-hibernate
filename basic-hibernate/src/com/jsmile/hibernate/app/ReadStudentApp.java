package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

public class ReadStudentApp
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
			Student student = new Student( "jsmile", "Jeong", "jsmile@naver.com" );
			// start a transaction
			session.beginTransaction();
			// save the student object
			session.save( student );
			// commit the transaction
			session.getTransaction().commit();

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id : primary key
			System.out.println( "\nGetting student with id : " + student.getId() );
			Student newStudent = session.get( Student.class, student.getId() );
			System.out.println( "New Student is " + newStudent );
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println( "\nDone!" );
			
		} 
		finally 
		{
			factory.close();
		}

	}

}
