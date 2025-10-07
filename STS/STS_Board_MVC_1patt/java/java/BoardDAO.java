package com.globalin.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	// JDBC 관련 변수 선언
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	// SQL 명령어
	private final String BOARD_INSERT
	= "insert into board(seq, title, writer, content) "
			+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE
	= "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE
	= "delete board where seq=?";
	private final String BOARD_GET
	= "select * from board where seq=?";
	private final String BOARD_LIST
	= "select * from board order by seq desc";
	
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoardVO (BoardVO vo) {
		System.out.println("=== JDBC로 insertBoard() 기능  처리");
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	// 글 수정
	public void updateBoardVO (BoardVO vo) {
		System.out.println("=== JDBC로 updateBoard() 기능  처리");
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3,vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	// 글 삭제
	public void deleteBoardVO (BoardVO vo) {
		System.out.println("=== JDBC로 deleteBoard() 기능  처리");
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1,vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	// 글  목록
	public List<BoardVO> getBoardList (BoardVO vo) {
		System.out.println("=== JDBC로 getBoard() 기능  처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_LIST);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO ();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return boardList;
	}
	
	// 글 상세 조회
	public BoardVO getBoardVO (BoardVO vo) {
		System.out.println("=== JDBC로 getBoard() 기능  처리");
		BoardVO board = null;
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_GET);
			pstmt.setInt(1,vo.getSeq());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO ();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return board;
	}
	
	//service
}