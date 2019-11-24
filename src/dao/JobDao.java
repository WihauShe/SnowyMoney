package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Job;
import util.ConnectionUtil;

public class JobDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	public int addJob(Job job){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "insert into job(category,sex,place,demand,salary,contact,userid) values(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, job.getJobCategory());
			ps.setString(2, job.getJobSex());
			ps.setString(3, job.getJobPlace());
			ps.setString(4, job.getJobDemand());
			ps.setString(5, job.getJobSalary());
			ps.setString(6, job.getJobContact());
			ps.setInt(7, job.getUserId());
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
	
	public ArrayList<Job> getJobsByTerms(String category,String sex,String place){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from job where category=? and (sex=? or sex='unlimit') and place=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, sex);
			ps.setString(3, place);
			rs = ps.executeQuery();
			ArrayList<Job> jobList = new ArrayList<Job>();
			while(rs.next()){
				int jobId = rs.getInt("id");
				String jobCategory=rs.getString("category");
				String jobSex = rs.getString("sex");
				String jobPlace = rs.getString("place");
				String jobDemand = rs.getString("demand");
				String jobSalary = rs.getString("salary");
				String jobContact = rs.getString("contact");
				int userId = rs.getInt("userid");
				
				Job job = new Job(jobId, jobCategory, jobSex, jobPlace, jobDemand, jobSalary, jobContact, userId);
				jobList.add(job);
			}
			return jobList;
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
	public ArrayList<Job> getJobsById(int userId){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from job where userid = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			ArrayList<Job> jobList = new ArrayList<Job>();
			while(rs.next()){
				int jobId = rs.getInt("id");
				String jobCategory=rs.getString("category");
				String jobSex = rs.getString("sex");
				String jobPlace = rs.getString("place");
				String jobDemand = rs.getString("demand");
				String jobSalary = rs.getString("salary");
				String jobContact = rs.getString("contact");
				
				Job job = new Job(jobId, jobCategory, jobSex, jobPlace, jobDemand, jobSalary, jobContact, userId);
				jobList.add(job);
			}
			return jobList;
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
	public int deleteJobById(int jobId){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "delete from job where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jobId);
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
}
