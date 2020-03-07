package com.jsmile.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC
{

	public static void main( String[] args )
	{
//		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		String jdbcURL = "jdbc:mariadb://127.0.0.1:3306/hb-04-one-to-many-uni?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		
		
		try 
		{
			System.out.println( "Connecting to database : " + jdbcURL );
			
			Connection con = DriverManager.getConnection( jdbcURL, user, password );
			
			if( con != null ) 
			{
				System.out.println( "DB Connection is successful." );
			}
			
			con.close();
		} 
		catch (SQLException  e) 
		{
			System.out.println( "DB connection is failed !" );
			e.printStackTrace();			
		}
		
	}

}
