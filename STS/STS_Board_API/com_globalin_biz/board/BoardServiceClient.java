package com.globalin.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		/* 1. Spring 컨테이너를 구동함*/
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		
		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 요청함
		BoardService boardService = (BoardService)factory.getBean("boardService");
		
		// 3. 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시내용............");
		boardService.insertBoard(vo);
		
		// 4. 글 목록  기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for (BoardVO board : boardList) {
			System.out.println("------> " +board.toString());
		}

		// 5. Spring 컨테이너 종료
		factory.close();
		
	}
}