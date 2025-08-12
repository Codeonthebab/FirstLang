<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <jsp:useBean id = "customer" class="com.actiontag.Customer"> </jsp:useBean>
    <jsp:setProperty property="*" name="customer"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body >
니놈의 정보는 내가 털었다ㅋㅋㅋ 앞으로 경각심을 가지고 살도록 <br/>
[털린 목록]
<ol >
<li>이름 : <jsp:getProperty property="name" name="customer"/> </li>
<li>이메일 : <jsp:getProperty property="email" name="customer"/> </li>
<li>전화번호 : <jsp:getProperty property="tel" name="customer"/> </li>
<li>생년월일 : <jsp:getProperty property="birth" name="customer"/> </li>
</ol>
</body>
</html>