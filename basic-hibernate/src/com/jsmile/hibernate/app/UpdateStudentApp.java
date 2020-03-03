package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

public class UpdateStudentApp
{

	public static void main( String[] args )
	{
		// create a session factory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Student.class )
																	.buildSessionFactory();
		try 
		{
			// create a session
			Session session = factory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			// create a needed object
			int studentId = 1;
			// make a object query 
			Student student = session.get( Student.class, studentId );
			student.setFirstName( "janey" );		// update the student			
			// display the student
			System.out.println( "\n### Updated Student is : " + student );
			// commit 
			session.getTransaction().commit();
			
			// New SQL Query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println( "\nUpdating all students whose email ends with @luv2.com...." );
			session.createQuery( 
					"UPDATE Student s SET s.email='foo@gmail.com'"
					+ " WHERE s.email LIKE '%luv2code.com'"  
					).executeUpdate();
			System.out.println( "Succesful Update by HSQL !!" );
			
			session.getTransaction().commit();
		} 
		// close the session factory
		finally { factory.close(); }

	}

}
