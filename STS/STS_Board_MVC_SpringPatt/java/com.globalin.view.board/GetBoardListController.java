package com.globalin.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("글 목록 접근 처리");
		
		// 데이터베이스 연동
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 세션에 로그인 정보를 저장, 목록화면으로 이동
/*
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
//		response.sendRedirect("getBoardList.jsp");*/

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);// 모델정보 저장
		mav.setViewName("getBoardList"); // 뷰정보 저장
		return mav;
//		return "getBoardList";
	}

}
