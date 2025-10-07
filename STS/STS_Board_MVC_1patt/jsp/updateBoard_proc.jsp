<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>

<% request.setCharacterEncoding("utf-8");
String title=request.getParameter("title");
String content=request.getParameter("content");
String seq=request.getParameter("seq");

//데이터 베이스 연동 
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoardVO(vo);


// 응답 화면 구성
response.sendRedirect("getBoardList.jsp");
%>