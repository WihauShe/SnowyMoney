package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.ConnectionUtil;

public class UserDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	public int addUser(User user){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "insert into user(name,phone,sex,age,email,password) values(?,?,?,?,?,?);";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPhone());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getUserEmail());
			ps.setString(6, user.getUserPassword());
			result = ps.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		      
			 if ( ps != null ) {
			     try { ps.close(); }
			     catch (SQLException se) { se.printStackTrace(System.err); }
		     }
			 if ( connection != null ) {
				 try { connection.close(); }
			     catch (Exception e) { e.printStackTrace(System.err); }
			 }
		 } // END of try-catch-finally block
		return result;
	}
	public int updatePassByPhone(String userPhone,String userPassword){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "update user set password = ?  where phone = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userPassword);
			ps.setString(2, userPhone);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			  if ( ps != null ) {
				  try { ps.close(); }
			      catch (SQLException se) { se.printStackTrace(System.err); }
			  }
			  if ( connection != null ) {
			      try { connection.close(); }
			      catch (Exception e) { e.printStackTrace(System.err); }
			  }
		 } // END of try-catch-finally block
		return result;
	}
	public int getUserIdByPhone(String userPhone){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userId = 0;
		try {
			String sql = "select id from user where phone = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			while(rs.next()){
				userId = rs.getInt("id");
			}
			return userId;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		      if ( rs != null ) {
			        try { rs.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( ps != null ) {
			        try { ps.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( connection != null ) {
			        try { connection.close(); }
			        catch (Exception e) { e.printStackTrace(System.err); }
			      }
		 } // END of try-catch-finally block
		return userId;
	}
	public String getEmailByPhone(String userPhone){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String userEmail = "";
		try {
			String sql = "select email from user where phone = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			while(rs.next()){
				userEmail = rs.getString("email");
			}
			return userEmail;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		      if ( rs != null ) {
			        try { rs.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( ps != null ) {
			        try { ps.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( connection != null ) {
			        try { connection.close(); }
			        catch (Exception e) { e.printStackTrace(System.err); }
			      }
		 } // END of try-catch-finally block
		return userEmail;
	}
	public String getPassByPhone(String userPhone){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String userPassword = "";
		try {
			String sql = "select password from user where phone = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			while(rs.next()){
				userPassword = rs.getString("password");
			}
			return userPassword;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		      if ( rs != null ) {
			        try { rs.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( ps != null ) {
			        try { ps.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( connection != null ) {
			        try { connection.close(); }
			        catch (Exception e) { e.printStackTrace(System.err); }
			      }
		 } // END of try-catch-finally block
		return userPassword;
	}
	public User getUserById(int userId){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				String userName=rs.getString("name");
				String userPhone=rs.getString("phone");
				String userSex=rs.getString("sex");
				int userAge=rs.getInt("age");
				String userEmail=rs.getString("email");
				user = new User(userId,userName,userPhone,userSex,userAge,userEmail,"***");
			}
			return user;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		      if ( rs != null ) {
			        try { rs.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( ps != null ) {
			        try { ps.close(); }
			        catch (SQLException se) { se.printStackTrace(System.err); }
			      }
			      if ( connection != null ) {
			        try { connection.close(); }
			        catch (Exception e) { e.printStackTrace(System.err); }
			      }
		 } // END of try-catch-finally block
		return null;
	}
}
