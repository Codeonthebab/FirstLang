<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/mvcmem/script.js"></script>
</head>
<body bgcolor = "white">
<div align = "center">
<b>${id}</b>
<c:if test = "${check eq true}"> 는 이미 존재하는 ID 입니다. </c:if><br><br>
<c:if test = "${check ne true}"> 는 사용가능한 ID 입니다. </c:if><br><br>
<a href="javascript:self.close()"> X </a>
</div>
</body>
</html>