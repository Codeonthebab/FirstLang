package com.boardone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private static BoardDAO instance = null;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {

		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	// 여기서부터 게시판에 작업한 기능을 하나씩 메소드로 구현하여 추가하면 됨

	/*
	 * 실제 데이터베이스에 데이터를 저장할 메소드 구현 insertArticle(BoardVO article)
	 */
	public void insertArticle(BoardVO article) {
		Connection con = null;
		// 각 쿼리에 대해 PreparedStatement 변수를 분리
		PreparedStatement pstmtMaxNum = null;
		PreparedStatement pstmtUpdate = null;
		PreparedStatement pstmtInsert = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		int number = 0;
		String sql = "";

		try {
			con = ConnUtil.getConnection();
			pstmtMaxNum = con.prepareStatement("select max(num) from board");
			rs = pstmtMaxNum.executeQuery();
			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) { // 답변글
				sql = "update board set step=step+1 where ref=? and step>?";
				pstmtUpdate = con.prepareStatement(sql);
				pstmtUpdate.setInt(1, ref);
				pstmtUpdate.setInt(2, step);
				pstmtUpdate.executeUpdate();
				step = step + 1;
				depth = depth + 1;
			} else { // 새글
				ref = number;
				step = 0;
				depth = 0;
			}

			sql = "insert into board (num, writer, email, " + "subject, pass, regdate, ref, step, depth, content, ip) "
					+ "values (board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmtInsert = con.prepareStatement(sql);
			pstmtInsert.setString(1, article.getWriter());
			pstmtInsert.setString(2, article.getEmail());
			pstmtInsert.setString(3, article.getSubject());
			pstmtInsert.setString(4, article.getPass());
			pstmtInsert.setTimestamp(5, article.getRegdate());
			pstmtInsert.setInt(6, ref);
			pstmtInsert.setInt(7, step);
			pstmtInsert.setInt(8, depth);
			pstmtInsert.setString(9, article.getContent());
			pstmtInsert.setString(10, article.getIp());
			pstmtInsert.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ss) {
				}
			if (pstmtMaxNum != null)
				try {
					pstmtMaxNum.close();
				} catch (SQLException ss) {
				}
			if (pstmtUpdate != null)
				try {
					pstmtUpdate.close();
				} catch (SQLException ss) {
				}
			if (pstmtInsert != null)
				try {
					pstmtInsert.close();
				} catch (SQLException ss) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ss) {
				}
		}
	} // end insert

	/*
	 * [글 목록 화면 만들기] - 전체 글의 개수를 가져올 메소드를 구현함 int getArticleCount()
	 * 
	 */
	public int getArticleCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;

		try {
			con = ConnUtil.getConnection();
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
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
		return x;
	}

	 /* - 데이터베이스에 있는 전체 글을 가져다가 리스트에 저장하고, 검색기능을 실현시키기 위함
	 */
	public List<BoardVO> getArticles(int start, int end, String searchField, String searchWord) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = new ArrayList<BoardVO>();

		try {
			con = ConnUtil.getConnection();
			String sql = "select * from (select rownum rnum, num, writer, email, "
					+ "subject, pass, regdate, readcount, ref, step, depth, content, "
					+ "ip from (select * from board where " +searchField+ " like ? order by ref desc, step asc)) " 
					+ "where rnum >=? and rnum <=?";
			// String sql = "select * from board order by ref desc, step asc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				articleList.add(article); // 목록 채우기
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
		return articleList;
	}
	
	public List<BoardVO> getArticles(int start, int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = new ArrayList<BoardVO>();

		try {
			con = ConnUtil.getConnection();
			String sql = "select * from (select rownum rnum, num, writer, email, "
					+ "subject, pass, regdate, readcount, ref, step, depth, content, "
					+ "ip from (select * from board order by ref desc, step asc)) " 
					+ "where rnum >=? and rnum <=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			BoardVO article = new BoardVO();
			article.setNum(rs.getInt("num"));
			article.setWriter(rs.getString("writer"));
			article.setEmail(rs.getString("email"));
			article.setSubject(rs.getString("subject"));
			article.setPass(rs.getString("pass"));
			article.setRegdate(rs.getTimestamp("regdate"));
			article.setReadcount(rs.getInt("readcount"));
			article.setRef(rs.getInt("ref"));
			article.setStep(rs.getInt("step"));
			article.setDepth(rs.getInt("depth"));
			article.setContent(rs.getString("content"));
			article.setIp(rs.getString("ip"));
			articleList.add(article); // 목록 채우기
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
		return articleList;
	}
	
	/*
	 * 글 내용 보기 글의 번호를 매개변수로 해서 하나의 글에 대한 상세정보를 데이터 베이스에서 가져옴
	 * 
	 */

	public BoardVO getArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {
			con = ConnUtil.getConnection();
			String sql1 = "update board set readcount = readcount+1 where num=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			String sql2 = "select * from board where num=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
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
		return article;
	}// end getArticle
	/*
	 * 글 수정시에는 글 목록보기와 다르게 조회수를 증가시킬 필요가 없다 조회수를 증가시키는 부분을 제외하고, num에 해당하는 게시글만 가져오는
	 * 메소드를 구현함
	 */

	public BoardVO updateGetArticle(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;

		try {
			con = ConnUtil.getConnection();
			/*
			 * String sql1 = "update board set readcount = readcount+1 where num=?"; pstmt =
			 * con.prepareStatement(sql1); pstmt.setInt(1, num); pstmt.executeUpdate();
			 */
			String sql2 = "select * from board where num=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
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
		return article;
	}

	/*
	 * updateForm.jsp에서 비밀번호를 입력하고 글 수정 버튼을 클릭하면 데이터 베이스에서 실제 글이 수정되어야 한다.
	 */

	public int updateArticle(BoardVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpassword = "";
		String sql = "";
		int result = -1;

		try {
			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpassword = rs.getString("pass");
				if (dbpassword.equals(article.getPass())) {
					// 데이터베이스에 저장된 비밀번호와 내가 입력한 비밀번호가 일치하면 글 수정 처리한다
					sql = "update board set writer=?, email=?, subject=?, content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeUpdate();
					result = 1; // 글수정 성공
				} else {
					result = 0; // 글수정 실패
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
		return result;
	} // end updateArticle

	/*
	 * 글삭제할꼬얌 글 삭제 버튼을 클릭하여 글 삭제 화면이 나오면 비밀번호를 입력하고 삭제를 처리한다. 이때, 데이터베이스에서 비밀번호를
	 * 비교하여 일치하면 글 삭제 처리를 수행한다.
	 * 
	 */

	public int deleteArticle(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpassword = "";
		String sql = "";
		int result = -1;

		try {
			con = ConnUtil.getConnection();

			pstmt = con.prepareStatement("select pass from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpassword = rs.getString("pass");
				if (dbpassword.equals(pass)) {
					// 데이터베이스에 저장된 비밀번호와 내가 입력한 비밀번호가 일치하면 글 수정 처리한다
					sql = "delete from board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					result = 1; // 글수정 성공
				} else {
					result = 0; // 글수정 실패
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
		return result;
	} // end deleteArticle
	
	/*
	 * 검색기능 구현 
	 * jsp에서 받은 searchField, searchWord 데이터를 DB에 직접 접속 시켜서 검색하게끔 구현한다.
	 * 
	 * getArticleCount로 서치필드와, 서치와드 글을 통해 해당되는 글 갯수 검색 기능 구현
	 */
	public int getArticleCount (String searchField, String searchWord) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select count(*) from board where " + searchField+ " like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+ "%");
			rs = pstmt.executeQuery();
			
			if (rs.next()) { x = rs.getInt(1); }
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
		return x;
	} // getArticle
	
	/*    
	 * 
	 */
}
