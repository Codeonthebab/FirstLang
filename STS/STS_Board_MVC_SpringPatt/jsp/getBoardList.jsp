<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>   


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<div align = "center">
<h1>글 목록</h1>
<h3>${userName}님, 환영할지도 모릅니다. <a href="logout.do"> Log-Out</a></h3>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<th bgcolor="orange" width="100"> 번호 </th>
<th bgcolor="orange" width="200"> 제목 </th>
<th bgcolor="orange" width="150"> 작성자 </th>
<th bgcolor="orange" width="150"> 등록일 </th>
<th bgcolor="orange" width="100"> 조회수 </th>
</tr>

<c:forEach var="board" items="${boardList}">
<tr>
    <td>${board.seq}</td>
    <td align="left">
        <a href="getBoard.do?seq=${board.seq}">${board.title}</a>
    </td>
    <td>${board.writer}</td>
    <td>${board.regDate}</td>
    <td>${board.cnt}</td>
</tr>
</c:forEach>

</table>
<br>
<a href="insertBoard.do"> 새글 등록 </a>
</div>
</body>
</html>