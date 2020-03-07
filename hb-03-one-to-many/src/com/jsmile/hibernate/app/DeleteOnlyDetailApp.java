package com.jsmile.hibernate.app;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsmile.hibernate.entity.Instructor;
import com.jsmile.hibernate.entity.InstructorDetail;

/**
 *  Bidirectional Delete :
 *  not Instructor row but DetailInstructor row
 *  just Instructor column but DetailInstructor row  
 * */
public class DeleteOnlyDetailApp
{

	public static void main( String[] args )
	{
		// create a session factory
		SessionFactory factory = new Configuration()
																	.configure( "hibernate.cfg.xml" )
																	.addAnnotatedClass( Instructor.class )
																	.addAnnotatedClass( InstructorDetail.class )
																	.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try 
		{
			// begin transaction
			session.beginTransaction();
			// create the needed object
			System.out.println( "Delete Only Detail Target : 6" );
			int theId = 6;
			InstructorDetail detail = session.get( InstructorDetail.class, theId );
			// remove the associated object reference
			// - break the bi-directional link
			detail.getInstructor().setInstructorDetail( null );			
			
			// execute a query : delete an instructor and his detail
			// because of 
			// @OneToOne( cascade=CascadeType.ALL )
			// @JoinColumn( name="instructor_detail_id" )
			session.delete( detail );
			System.out.println( "Only Detail is Deleted !!" );
			// commit 
			session.getTransaction().commit();
		}
		catch( Exception e ) { e.getCause(); }
		finally 
		{
			session.close();
			// close factory
			factory.close();
		}

	}

}
