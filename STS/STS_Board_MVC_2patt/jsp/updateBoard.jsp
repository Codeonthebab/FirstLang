<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>

<%
// 세션에 저장된 게시글 정보를 가져옴
BoardVO board = (BoardVO) session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 상세</title>
</head>
<body>
<div align="center">
    <h1>글 상세</h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <form action="updateBoard.do" method="post">
        <input type="hidden" name="seq" value="<%= board.getSeq() %>" />
        
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">작성자</td>
                <td align="left"><%= board.getWriter() %></td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
            </tr>
            <tr>
                <td bgcolor="orange">등록일</td>
                <td align="left"><%= board.getRegDate() %></td>
            </tr>
            <tr>
                <td bgcolor="orange">조회수</td>
                <td align="left"><%= board.getCnt() %></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="글 수정"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="insertBoard.do">글 등록</a>&nbsp;&nbsp;&nbsp;
    <a href="deleteBoard.do?seq=<%= board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="getBoardList.do">글 목록</a>
</div>
</body>
</html>