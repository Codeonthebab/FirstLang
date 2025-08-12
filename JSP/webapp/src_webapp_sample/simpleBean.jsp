<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    //String message= request.getParameter("message");
    %>
    
    <jsp:useBean id = "msg" class="com.sample.SimpleData"></jsp:useBean>
    <%--SimpleData msg = new SimpleData(); --%>
    
    <jsp:setProperty property="message" name="msg"/>
    <%-- msg.setMessage(String message); --%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>자바 빈즈 결과</h1>
<hr color = "red">
<font size="5">메세지 : <jsp:getProperty property="message" name = "msg"/>
<%--<%=message --%>
</font>
</body>
</html>