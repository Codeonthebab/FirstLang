package com.globalin.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.globalin.biz.common.JDBCUtil;
import com.globalin.biz.user.UserService;
import com.globalin.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO implements UserService {

	private Connection con = null;
	private PreparedStatement  stmt = null;
	private ResultSet rs = null;

    private final String USER_GET=
    		"select * from users where id=? and password=?";
	
	@Override
	public UserVO getUser(UserVO vo) {
		
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리...");
			con = JDBCUtil.getConnection();
			stmt = con.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, con);
		}
		return user;
	}
	
	@SuppressWarnings("unused")
	private void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		
		try {
			if (rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (conn != null) conn.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
