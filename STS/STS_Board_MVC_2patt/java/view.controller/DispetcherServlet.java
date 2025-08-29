package com.globalin.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

//@WebServlet(name="action", urlPatterns= {"*.do"})
public class DispetcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HandlerMapping handlerMapping;
    private ViewResolver ViewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		ViewResolver = new ViewResolver();
		
		ViewResolver.setPrefix("./");
		ViewResolver.setSuffix(".jsp");
		
		// prefix(./login) View 리졸브 
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트의 요청 경로 정보를 추출함
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("요청 Path : " + path);
		
		// 2. HandlerMapping을 통해서 path에 해당하는 Controller를 검색함
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller 실행함
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해서 viewName에 해당하는 화면을 검색함
		String view = null;
		if(!viewName.contains(".do")) {
			view = ViewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동함
		response.sendRedirect(view);
		
		
		// 2. 클라이언트의 요청 경로에 따라 적적히 분기 처리함
		/* MVC 2
		 * if (path.equals("/login.do")) {
				
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			request.setCharacterEncoding("utf-8");
			String title=request.getParameter("title");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");

			//데이터 베이스 연동 
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoardVO(vo);

			// 응답 화면 구성
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			 // 요청 방식을 확인하여 GET과 POST를 분기 처리
		    if ("GET".equals(request.getMethod())) {
		        System.out.println("글 수정 화면으로 이동 처리 (GET)");

		        // 1. seq 파라미터로 기존 글 정보를 조회
		        String seq = request.getParameter("seq");
		        BoardVO vo = new BoardVO();
		        vo.setSeq(Integer.parseInt(seq));

		        BoardDAO boardDAO = new BoardDAO();
		        BoardVO board = boardDAO.getBoardVO(vo);
		        
		        // 2. 조회한 정보를 세션에 저장
		        HttpSession session = request.getSession();
		        session.setAttribute("board", board);
		        
		        // 3. 수정 화면(updateBoard.jsp)으로 이동
		        response.sendRedirect("updateBoard.jsp");

		    } else if ("POST".equals(request.getMethod())) {
		        System.out.println("글 수정 DB 처리 (POST)");

		        // 1. 폼에서 전송된 파라미터 추출
		        request.setCharacterEncoding("utf-8");
		        String title = request.getParameter("title");
		        String content = request.getParameter("content");
		        String seq = request.getParameter("seq");

		        // 2. 추출한 정보로 DB 업데이트
		        BoardVO vo = new BoardVO();
		        vo.setTitle(title);
		        vo.setContent(content);
		        vo.setSeq(Integer.parseInt(seq));

		        BoardDAO boardDAO = new BoardDAO();
		        boardDAO.updateBoardVO(vo);
		        
		        // 3. 수정된 결과를 보여주기 위해 상세 보기 페이지로 리다이렉트 (PRG 패턴)
		        response.sendRedirect("getBoard.do?seq=" + vo.getSeq());
		    }
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			String seq=request.getParameter("seq");

			//데이터 베이스 연동 
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoardVO(vo);

			// 응답 화면 구성
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			//DB 연동
		    String seq = request.getParameter("seq");

		    BoardVO vo = new BoardVO();
		    vo.setSeq(Integer.parseInt(seq));

		    BoardDAO boardDAO = new BoardDAO();
		    BoardVO board = boardDAO.getBoardVO(vo);
			
			// 세션에 로그인 정보를 저장, 목록화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		    
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 접근 처리");
			
			// 데이터베이스 연동
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 세션에 로그인 정보를 저장, 목록화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}*/
	}
}
