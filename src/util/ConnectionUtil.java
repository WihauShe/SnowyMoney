package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	public Connection getConnection(){
		
		DataSource ds = null;
	    Connection connection = null;
	    try {
	    	  Context ctx = new InitialContext();
		      if ( ctx == null ) {
		        throw new RuntimeException("JNDI Context could not be found.");
		      }
		      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/SnowyMoney");
		      if ( ds == null ) {
		        throw new RuntimeException("DataSource could not be found.");
		      }
		      connection = ds.getConnection();
		      return connection;
		}catch (SQLException se) {
		      throw new RuntimeException("A database error occured. "+se.getMessage());

		// Handle any JNDI errors
		} catch (NamingException ne) {
		throw new RuntimeException("A JNDI error occured. "+ne.getMessage());
		
		// Clean up JDBC resources
		} 
	}
}
