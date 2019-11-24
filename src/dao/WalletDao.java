package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Wallet;
import util.ConnectionUtil;

public class WalletDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	public int addWallet(Wallet wallet){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			String sql = "insert into wallet values(?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, wallet.getUserId());
			ps.setInt(2, wallet.getBalance());
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
	public int getBalanceById(int userId){
		Connection connection = connectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int balance = -1;
		try {
			String sql = "select balance from wallet where userid = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				balance = rs.getInt("balance");
			}
			return balance;
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
		return balance;
	}
}
