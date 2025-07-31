package com.memberone;

import java.sql.*;
import java.util.Vector;

import javax.sql.*;
import javax.naming.*;

public class StudentDAO {

	private Connection getConnection() {
		Connection con = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection 생성 실패");
		}
		return con;
	}

	// 아이디 중복 검사
	public boolean idCheck(String id) {

		boolean result = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql1 = "select * from student where id = ?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next())
				result = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
		}
		return result;
	}
	// end idcheck

	//우편번호를 DB에서 검색해서 컬렉션에 저장
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector <ZipCodeVO> vecList = new Vector <ZipCodeVO> ();
		
		try {
			con = getConnection();
			String sql = "select * from zipcode where dong like '" +dong+ "%'";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ZipCodeVO tZipcode = new ZipCodeVO ();
				tZipcode.setZipcode(rs.getString("zipcode"));
				tZipcode.setSido(rs.getString("sido"));
				tZipcode.setGugun(rs.getString("gugun"));
				tZipcode.setDong(rs.getString("dong"));
				tZipcode.setRi(rs.getString("ri"));
				tZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tZipcode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException ss) {ss.printStackTrace(); }
			if (pstmt != null) try{pstmt.close();} catch (SQLException ss) {ss.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException ss) { ss.printStackTrace();}
		}
		return vecList;
	}
	
	/* 회원 가입 처리 구현
	 * 데이터 베이스에 회원 데이터를 저장하기 위한 메소드를 구현
	 * 
	 */
	
	public boolean memberInsert(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		try {
			con = getConnection();
			String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			
			
			int count = pstmt.executeUpdate();
			if (count > 0) flag = true;
		} catch (SQLException e) {
			System.out.println("Exception: "+e);
			e.printStackTrace();
		} finally {
			if (pstmt != null) try{pstmt.close();} catch (SQLException ss) {ss.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException ss) { ss.printStackTrace();}
		}
		return flag;
	}
	
	/*		[로그인 구현]
	 *		- 로그인 버튼을 클릭하면 입력한 id/password를 데이터베이스에 저장되어 있는
	 *			id/password와 비교해서 같으면 로그인 성공, 다르면 로그인 실패처리함
	 *		-  '1' : 로그인 성공, '0': 비밀번호 오류, '-1': 아이디가 존재하지 않음
	 */
	
	public int loginCheck(String id, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1;  // 아이디가 존재하지 않는 것에서부터 시작
		
		try {
			con = getConnection();
			String sql = "select pass from student where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbPass = rs.getString("pass");
				if (pass.equals(dbPass)) {
					check=1; // 로그인 성공
				} else {
					check=0; // 로그인 실패
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException ss) {ss.printStackTrace(); }
			if (pstmt != null) try{pstmt.close();} catch (SQLException ss) {ss.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException ss) { ss.printStackTrace();}
		}
		return check;
	}
}