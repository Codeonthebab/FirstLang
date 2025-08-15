<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	if (code.equals("A")) {
		viewPageURI = "viewModule/Apage.jsp";
	} else if (code.equals("B")) {
		viewPageURI = "viewModule/Bpage.jsp";
	} else if (code.equals("C")) {
		viewPageURI = "viewModule/Cpage.jsp";
	}
	%>
	<jsp:forward page="<%=viewPageURI %>" />
</body>
</html>