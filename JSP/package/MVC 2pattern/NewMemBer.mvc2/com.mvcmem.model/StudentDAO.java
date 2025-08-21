package com.mvcmem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import com.mvcmem.model.StudentVO;

public class StudentDAO {

	private static StudentDAO instance = null;

	private StudentDAO() {
	}

	public static StudentDAO getInstance() {
		if (instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}

	private Connection getConnection() { // 이 친구를 공유해서 활용한다
		Connection con = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
		} catch (NamingException ne) {
			System.out.println("Connection  Failed");
		} catch (SQLException se) {
			System.out.println("Connection Failed");
			se.printStackTrace();
		}
		return con;
	}
	
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
	} // end idcheck
	
	// 우편번호를 DB에서 검색해서 컬렉션에 저장
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();

		try {
			con = getConnection();
			String sql = "select * from zipcode where dong like '" + dong + "%'";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipCodeVO tZipcode = new ZipCodeVO();
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
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
		return vecList;
	}

	/*
	 * 회원 가입 처리 구현 데이터 베이스에 회원 데이터를 저장하기 위한 메소드를 구현
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
			if (count > 0)
				flag = true;
		} catch (SQLException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
		return flag;
	}

	/*
	 * [로그인 구현] - 로그인 버튼을 클릭하면 입력한 id/password를 데이터베이스에 저장되어 있는 id/password와 비교해서
	 * 같으면 로그인 성공, 다르면 로그인 실패처리함 - '1' : 로그인 성공, '0': 비밀번호 오류, '-1': 아이디가 존재하지 않음
	 */

	public int loginCheck(String id, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1; // 아이디가 존재하지 않는 것에서부터 시작

		try {
			con = getConnection();
			String sql = "select pass from student where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbPass = rs.getString("pass");
				if (pass.equals(dbPass)) {
					check = 1; // 로그인 성공
				} else {
					check = 0; // 로그인 실패
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
		return check;
	}
	/*
	 * [정보 수정] - 정보 수정 버튼을 클릭하면 현재 로그인한 회원의 정보를 수정할 수 있도록 미리 데이터베이스에서 정보를 가져온다. 1.
	 * 회원정보를 가져올 메소드를 구현한다. getMember(String id)
	 */

	public StudentVO getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO vo = null;

		try {
			con = getConnection();
			String sql = "select * from student where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 아이디에 해당하는 회원이 존재한다면
				vo = new StudentVO();
				vo.setId(rs.getString("id")); // 가져올 DB의 행
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("Phone1"));
				vo.setPhone2(rs.getString("Phone2"));
				vo.setPhone3(rs.getString("Phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
		return vo;
	}

	/*
	 * 회원 정보 수정 버튼을 클릭하면 데이터 베이스에서 수정처리를 싱행한다
	 *
	 */
	public void updateMember(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "update student set pass=?, phone1=?, phone2=?, "
					+ "phone3=?, email=?, zipcode=?, address1=?, address2=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
	}

	/*
	 * 회원 탈퇴 버튼을 클릭하면 데이터베이스에서 회원데이터가 삭제 되어여함 회원 삭제를 처리할 메소드를 구현한다.
	 */

	public int deleteMember(String id, String pass) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -1; // 인트 값으로 회원 탈퇴를 구분짓게끔
		String dbPass = "";

		try {
			String sql1 = "select pass from student where id=?";
			con = getConnection();
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //select 문을 실행하기 위함
			
			if (rs.next()) {
				dbPass = rs.getString("pass");
				if (dbPass.equals(pass)) { //본인인증이 성공했을 경우
					String sql2 = "delete from student where id=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1; // 삭제 성공 값 반환
				} else {
					result = 0; // 비밀번호 오류, 삭제 실패 값 반환
				}
			} // if문 끝
			
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
		}
		return result;
	}
}