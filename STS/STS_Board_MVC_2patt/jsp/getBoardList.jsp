<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.globalin.biz.board.BoardVO"%>
<%@ page import="java.util.List"%>

<%
 	// 세션에 저장한 글 목록 가져오기
 	List<BoardVO> boardList = (List) session.getAttribute("boardList");

 	// 응답화면 구성
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<div align = "center">
<h1>글 목록</h1>
<h3>테스트님, 환영할지도 모릅니다. <a href="logout.do"> Log-Out</a></h3>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<th bgcolor="orange" width="100"> 번호 </th>
<th bgcolor="orange" width="200"> 제목 </th>
<th bgcolor="orange" width="150"> 작성자 </th>
<th bgcolor="orange" width="150"> 등록일 </th>
<th bgcolor="orange" width="100"> 조회수 </th>
</tr>

<% for(BoardVO board : boardList) { %>

<tr>
    <td><%=board.getSeq()%></td>
    <td align="left">
        <a href="getBoard.do?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a>
    </td>
    <td><%=board.getWriter()%></td>
    <td><%=board.getRegDate()%></td>
    <td><%=board.getCnt()%></td>
</tr>

<%} %>
</table>
<br>
<a href="insertBoard.do"> 새글 등록 </a>
</div>
</body>
</html>