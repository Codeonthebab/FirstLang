package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 수정 처리");
		BoardVO vo = new BoardVO();
		
		// 요청 방식을 확인하여 GET과 POST를 분기 처리
	    if ("GET".equals(request.getMethod())) {
	        System.out.println("글 수정 화면으로 이동 처리 (GET)");

	        // 1. seq 파라미터로 기존 글 정보를 조회
	        String seq = request.getParameter("seq");
	        //BoardVO vo = new BoardVO();
	        vo.setSeq(Integer.parseInt(seq));

	        BoardDAO boardDAO = new BoardDAO();
	        BoardVO board = boardDAO.getBoardVO(vo);
	        
	        // 2. 조회한 정보를 세션에 저장
	        HttpSession session = request.getSession();
	        session.setAttribute("board", board);
	        
	        // 3. 수정 화면(updateBoard.jsp)으로 이동
	        //response.sendRedirect("updateBoard.jsp");

	    } else if ("POST".equals(request.getMethod())) {
	        System.out.println("글 수정 DB 처리 (POST)");

	        // 1. 폼에서 전송된 파라미터 추출
	        //request.setCharacterEncoding("utf-8");
	        String title = request.getParameter("title");
	        String content = request.getParameter("content");
	        String seq = request.getParameter("seq");

	        // 2. 추출한 정보로 DB 업데이트
	        //BoardVO vo = new BoardVO();
	        vo.setTitle(title);
	        vo.setContent(content);
	        vo.setSeq(Integer.parseInt(seq));

	        BoardDAO boardDAO = new BoardDAO();
	        boardDAO.updateBoardVO(vo);
	        
	        // 3. 수정된 결과를 보여주기 위해 상세 보기 페이지로 리다이렉트 (PRG 패턴)
	        //response.sendRedirect("getBoard.do?seq=" + vo.getSeq());
	    }
	    ModelAndView mav = new ModelAndView();
		mav.setViewName("updateBoard"); // 뷰정보 저장
		return mav;
	    
		//return "updateBoard";
	}

}
