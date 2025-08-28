package com.globalin.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection con) {
		
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt=null;
			}
		}
		
		
		if (con != null) {
			try {
				if (!con.isClosed()) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con=null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		
		if (rs != null) {
			try {
				if (!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs=null;
			}
		}
		
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt=null;
			}
		}
		
		if (con != null) {
			try {
				if (!con.isClosed()) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con=null;
			}
		}
		
	}
}