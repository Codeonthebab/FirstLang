<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력 : viewParameter</title>
<style>
body {
	text-align: center;
	color: red;
	background-color: rgba(250, 245, 235, 1);
}

h1 {
	font-weight: bold;
	font-style: italic;
	font-size: 20px;
}
</style>
</head>
<h1>메이플 3글자의 환호성</h1>
<body>
	Name :
	<%=request.getParameter("name")%>
	Address:
	<%=request.getParameter("address")%>
	<br>
	<br>
	<%
	String[] values = request.getParameterValues("pet");
	if (values != null) {
		for (int i = 0; i < values.length; i++) {
		%>
	<%=values[i]%> &nbsp; <%
	}
	}
	%>
	<br><br>
	<%
	Enumeration<String> enumData = request.getParameterNames();
	while (enumData.hasMoreElements()) {
		String name = enumData.nextElement();
	%>
	<%=name%>
	<%
	}
	%>
	
	<br> <br>
	<%
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("name");	
	if (nameParam != null) {
	%>
	name = <%=nameParam[0] %>
	<%} %>

</body>
</html>