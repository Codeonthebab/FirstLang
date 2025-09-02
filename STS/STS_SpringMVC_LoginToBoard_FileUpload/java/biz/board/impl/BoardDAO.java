package com.globalin.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAO {

	// JDBC 관련 변수 선언
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
			+ "values((select nvl(max(seq), 0)+1 from board), ?,?,?)";

	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";

	/*
	 * private final String BOARD_UPDATE=
	 * "update board set title=?, writer=?, content=? where seq=?";
	 */
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// 검색 기능 : 조건이 제목일 때
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	// 검색 기능 : 조건이 내용일 때
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			con = JDBCUtil.getConnection();
			stmt = con.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, con);
		}
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			con = JDBCUtil.getConnection();
			stmt = con.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, con);
		}
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			con = JDBCUtil.getConnection();
			stmt = con.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, con);
		}
	}

	// 글 상세조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			con = JDBCUtil.getConnection();
			stmt = con.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
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
			JDBCUtil.close(rs, stmt, con);
		}
		return board;
	}

	// 글 목록
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			con = JDBCUtil.getConnection();
			if(vo.getSearchKeyword() != null && !vo.getSearchKeyword().equals("")) {
				if (vo.getSearchCondition().equals("TITLE")) {
					stmt = con.prepareStatement(BOARD_LIST_T);	
				} else if (vo.getSearchCondition().equals("CONTENT")) {
					stmt = con.prepareStatement(BOARD_LIST_C);	
				}
			stmt.setString(1, vo.getSearchKeyword());
			} else {
				stmt = con.prepareStatement(BOARD_LIST);	
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
			    BoardVO board = new BoardVO();
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
		}finally {
			JDBCUtil.close(rs, stmt, con);
		}
		return boardList;
	}
	
}
