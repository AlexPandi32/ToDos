package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class Db {
	
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	public int Add(Date date, String Task) throws Exception {
		   int i = 0;
		   Connection conn=getConnection();
		
		try {
			
			String sql = "INSERT INTO TODO VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date( date.getTime()));
			ps.setObject(2, Task);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if ( conn != null) {
				 conn.close();
			}
		}
	}
		public ResultSet Display(Date date) throws Exception {
			ResultSet rs = null;
			Connection conn=getConnection();
			try {
				String sql = "SELECT * FROM TODO WHERE DATE=?";
				PreparedStatement ps =  conn.prepareStatement(sql);
				ps.setObject(1, new java.sql.Date( date.getTime()));
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if ( conn != null) {
					// conn.close();
				}
			}
		}
	
		public int Edit(Date date,String Task_new,String Task)throws SQLException, Exception {
			Connection conn=getConnection();
			conn.setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE TODO SET TASK=? WHERE DATE=? AND TASK=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Task_new);
				ps.setObject(2, new java.sql.Date( date.getTime()));
				ps.setString(3, Task);
			    i = ps.executeUpdate();
				//System.out.print("Updated Success FULLy");
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
				return 0;
			} finally {
				if (conn!= null) {
					conn.commit();
					conn.close();
				}
			}
		}
		public int Delete(Date date,String Task ) throws SQLException, Exception {
			Connection conn=getConnection();
			 conn.setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM TODO WHERE TASK=? AND DATE=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Task);
				ps.setObject(2,new java.sql.Date( date.getTime()) );
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
				return 0;
			} finally {
				if ( conn != null) {
					conn.commit();
					conn.close();
				}
			}
		}


		public ResultSet getMonthTasks(Date fday, Date lday) throws Exception {
		
			ResultSet rs = null;
			Connection conn=getConnection();
			try {
				String sql = "SELECT DISTINCT DATE FROM TODO WHERE DATE  BETWEEN  ?  AND ?";
				PreparedStatement ps =  conn.prepareStatement(sql);
				ps.setObject(1, new java.sql.Date( fday.getTime()));
				ps.setObject(2, new java.sql.Date( lday.getTime()));
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return rs;
			} finally {
				if ( conn != null) {
					// conn.close();
				}
			}
		}
	
	
	
	
	
	
	}

	
