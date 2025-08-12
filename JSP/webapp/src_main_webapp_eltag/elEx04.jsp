<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3> 파라미터 값 </h3>
<br>
<form action="elEx04.jsp" method="post">
이름 : <input type="text" name="name" value="${param['name'] }">
		<input type="submit" value="확인">
</form>
<br>
이름 : ${param.name } 입니다. <br>
</body>
</html>