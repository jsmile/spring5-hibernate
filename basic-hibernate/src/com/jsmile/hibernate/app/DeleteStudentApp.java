package com.jsmile.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Student;

public class DeleteStudentApp
{

	public static void main( String[] args )
	{
		// create sessionFactory
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
			
			// get target object from session
			int iStudentId = 1;
			Student student = session.get( Student.class, iStudentId );
			// make a object query
			System.out.println( "\nHibernate deleting by object" );
			session.delete( student );
			System.out.println( "the student whoes id is 1 is deleted." );
			// make a HSQL query
			System.out.println( "\nHibernate deleting by HSQL" );
			session.createQuery( 
					"DELETE FROM Student"
					+ " WHERE id=2" 
					).executeUpdate();
			System.out.println( "the student whoes id is 2 is deleted." );
			
			// commit
			session.getTransaction().commit();
		} 
		finally { factory.close(); }
		

	}

}
