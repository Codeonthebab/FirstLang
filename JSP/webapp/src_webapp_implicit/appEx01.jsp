<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터를 읽어오기</title>
<style type = "text/css"> body {text-align: center;} ol {color: pink; display: inline-block; text-align: left;}</style>
</head>
<body>
초기화 파라미터 목록 : <br>
<ol>
<%
Enumeration <String> enumData=application.getInitParameterNames();
while (enumData.hasMoreElements()) {
	String initParamName =enumData.nextElement();
%>
<li> <%=initParamName%> : <strong><%=application.getInitParameter(initParamName)%></strong>

<%
}

%>


</ol>
</body>
</html>