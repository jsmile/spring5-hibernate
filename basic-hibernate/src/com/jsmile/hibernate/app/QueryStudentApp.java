package com.jsmile.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class QueryStudentApp
{

	public static void main( String[] args )
	{
		// create session factory
		SessionFactory factory = new Configuration()
				.configure( "hibernate.cfg.xml" )
				.addAnnotatedClass( Student.class )
				.buildSessionFactory();
		try 
		{
			// create session 
			Session session = factory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			// make query
			List<Student> students = session.createQuery( "FROM Student" ).getResultList();
			//	display students
			System.out.println( "\nDisplay students" );
			displayStudents( students );
			//	query students : lastName = "Dau"
			students = session.createQuery( "FROM Student s WHERE s.lastName='Dau'" )
												.getResultList();
			System.out.println( "\n\nDisplay student whose name is Dau." );
			displayStudents( students );
			
			students = session.createQuery( 
												"FROM Student s "
												+ "WHERE s.email LIKE '%luv2code.com'" 
								).getResultList();
			System.out.println( "\n\nDisplay student whose email is like luv2.com." );
			displayStudents( students );
			// commit transaction
			session.getTransaction().commit();
		} 
		finally 
		{
			// close factory
			factory.close();
		}

	}

	private static void displayStudents( List<Student> _students )
	{
		for( Student student : _students ) 
		{
			System.out.println( student );
		}
	}

}
