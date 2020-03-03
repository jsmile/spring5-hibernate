package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

/**
 *  1) id is started from 3000
 *  		ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=3000;
 *  2) to reset AUTO_INCREMENT TO 1
 *  		TRUNCATE hb_student_tracker.student;
 * */
public class AutoPrimaryKeyApp
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
			System.out.println( "Creating 3 objects..." );

			// create 3 student objects
			Student student1 = new Student( "Jane", "Dau", "jane3@luv2code.com" );
			Student student2 = new Student( "Peter", "Jamse", "peter3@luv2code.com" );
			Student student3 = new Student( "Teddy", "Brown", "teddy3@luv2code.com" );
//			student.setId( "0001" );
			// start a transaction
			session.beginTransaction();
			// save the student objects
			session.save( student1 );
			session.save( student2 );
			session.save( student3 );
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
