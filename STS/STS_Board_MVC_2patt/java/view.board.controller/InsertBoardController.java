package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.view.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");

		// 요청 방식을 확인하여 GET과 POST를 분기 처리
		if ("POST".equals(request.getMethod())) {
			System.out.println("글 등록 DB 처리 (POST)");

			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoardVO(vo);

			return "getBoardList.do"; // 목록 액션으로 리다이렉트

		} else { // GET 요청 처리
			System.out.println("글 등록 화면으로 이동 처리 (GET)");
			return "insertBoard"; // ViewResolve에서 접근시킴
		}
	}

}
