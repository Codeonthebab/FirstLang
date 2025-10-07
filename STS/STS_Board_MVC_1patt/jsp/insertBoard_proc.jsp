<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>

<% request.setCharacterEncoding("utf-8");
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
response.sendRedirect("getBoardList.jsp");
%>
