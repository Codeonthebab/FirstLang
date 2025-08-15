<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO" />
<jsp:useBean id="vo" class="com.memberone.StudentVO" />

<jsp:setProperty property="*" name="vo"/>

<%
boolean flag = dao.memberInsert(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffcc">
<br>
<div align = "center">
<%
if(flag) {
	out.println("<b>회원가입을 축하드립니다. </b>");
	out.println("<a href=login.jsp>로그인</a>");
} else {
	out.println("<b>다시 입력하여 주세요. </b>");
	out.println("<a href=regForm.jsp>다시 가입하세요.</a>");
}
%>
</div>


</body>
</html>