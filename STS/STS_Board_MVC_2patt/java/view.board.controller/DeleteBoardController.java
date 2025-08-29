package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		
		String seq=request.getParameter("seq");

		//데이터 베이스 연동 
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoardVO(vo);

		// 응답 화면 구성
		//response.sendRedirect("getBoardList.do");
		
		return "getBoardList.do";
	}

}
