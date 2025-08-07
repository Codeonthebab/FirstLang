<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="view/color.jsp"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="<%=bodyback_color%>">
	<div>
		<b>글삭제</b><br>
		<form action="deleteProc.jsp?pageNum=<%=pageNum%>" name="delForm"
			method="post" onsubmit="return deleteSave()">
			<table width="360" border="1" align="center" cellpadding="0"
				cellspacing="0">
				
				<tr height="30">
					<td align = "center" bgcolor="<%=value_color%>">
					<b>비밀번호를 입력해 주세요.</b>
					</td>
				</tr>
				
				<tr height="30">
					<td align = "center">
					비밀번호 : <input type="password" name="pass" size="10" maxlength="10">
					<input type = "hidden" name="num" value="<%=num %>">
					</td>
				</tr>
				
				<tr>
					<td align = "center" bgcolor="<%=value_color%>">
					<input type="submit" value="글삭제">
					<input type = "button" value="글목록"
					onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
				
				
			</table>
		</form>
	</div>
</body>
</html>