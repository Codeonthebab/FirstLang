<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>
<%@ page import="java.util.List"%>
<%
// 세션에 저장된 게시글 정보를 가져옴
BoardVO board = (BoardVO) session.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 글 상세 </title>
</head>
<body>
<div align="center">
    <h1> 글 상세 </h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <table border="1" cellspacing="0" cellpadding="0" width="700">
        <tr>
            <td bgcolor="orange" width="100"> 제목 </td>
            <td align="left"><%= board.getTitle() %></td>
        </tr>
        <tr>
            <td bgcolor="orange">작성자</td>
            <td align="left"><%= board.getWriter() %></td>
        </tr>
        <tr>
            <td bgcolor="orange" height="200">내용</td>
            <td align="left" valign="top"><%= board.getContent() %></td>
        </tr>
        <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left"><%= board.getRegDate() %></td>
        </tr>
        <tr>
            <td bgcolor="orange">조회수</td>
            <td align="left"><%= board.getCnt() %></td>
        </tr>
    </table>
    <hr>

    <a href="updateBoard.do?seq=<%= board.getSeq() %>">글 수정</a>&nbsp;&nbsp;&nbsp;
    
    <a href="deleteBoard.do?seq=<%= board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
    
    <a href="getBoardList.do">글 목록</a>
</div>
</body>
</html>