package com.globalin.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;

/*  update(), queryForInt(), query()
 */


@Repository("boardDAO")
public class BoardDAOSpring  extends JdbcDaoSupport {

	// SQL 명령어
		private final String BOARD_INSERT=
		"insert into board(seq, title, writer, content) "
		+ "values((select nvl(max(seq), 0)+1 from board), ?,?,?)";
		private final String BOARD_UPDATE=
				"update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE="delete from board where seq=?";
		private final String BOARD_GET="select * from board where seq=?";
		private final String BOARD_LIST="select * from board order by seq desc";
	
		@Autowired
	    public void setSuperDataSource(DataSource dataSource) {
	    	super.setDataSource(dataSource);
	    }
		
		
		// 검색 기능 : 조건이 제목일 때
		private final String BOARD_LIST_T="select * from board where title like '%'||?||'%' order seq by desc";
		// 검색 기능 : 조건이 내용일 때
		private final String BOARD_LIST_C="select * from board where content like '%'||?||'%' order seq by desc";
		
		// CRUD 기능의 메소드 구현
		// 글 등록
		public void insertBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 insertBoard() 기능 처리 ....");
			getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(),
					vo.getWriter(), vo.getContent());
		}
		
		// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 updateBoard() 기능 처리 ....");
			getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(),
					 vo.getContent(), vo.getSeq());
		}
		
		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리 ....");
			getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
		}
		
		// 글 상세보기
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoard() 기능 처리 ....");
			Object[] args = {vo.getSeq()};
			return getJdbcTemplate().queryForObject(BOARD_GET, args, 
					new BoardRowMapper());
		}
		
		// 글 목록 보기
		
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoardList() 기능 처리 ....");
			 // 검색 조건과 키워드가 있는지 확인
	        if (vo.getSearchCondition() != null && vo.getSearchKeyword() != null && !vo.getSearchKeyword().isEmpty()) {
	            String sql = "";
	            if (vo.getSearchCondition().equals("TITLE")) {
	                sql = BOARD_LIST_T;
	            } else if (vo.getSearchCondition().equals("CONTENT")) {
	                sql = BOARD_LIST_C;
	            }
	            
	            // 검색어가 포함된 쿼리를 실행하고 결과를 바로 리턴
	            Object[] args = { vo.getSearchKeyword() };
	            return getJdbcTemplate().query(sql, args, new BoardRowMapper());
	            
	        } else {
	            // 검색어가 없으면 전체 목록 조회 쿼리를 실행하고 결과를 바로 리턴
	            return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	        }
		}
		
}
