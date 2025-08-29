package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 상세 조회 처리");
		
		//DB 연동
	    String seq = request.getParameter("seq");

	    BoardVO vo = new BoardVO();
	    vo.setSeq(Integer.parseInt(seq));

	    BoardDAO boardDAO = new BoardDAO();
	    BoardVO board = boardDAO.getBoardVO(vo);
		
		// 세션에 로그인 정보를 저장, 목록화면으로 이동
		/*HttpSession session = request.getSession();
		session.setAttribute("board", board);
		//response.sendRedirect("getBoard.jsp");
		return "getBoard";*/
	    ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);// 모델정보 저장
		mav.setViewName("getBoard"); // 뷰정보 저장
		return mav;
	}

}
