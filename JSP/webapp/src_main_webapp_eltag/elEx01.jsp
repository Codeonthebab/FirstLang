<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.actiontag.*, java.util.*" %>
    <%
    Customer customer = new Customer();
    customer.setName("조해흠");
    customer.setEmail("johea@naver.com");
    customer.setTel("010-1111-1111");
    request.setAttribute("customer", customer);
    
    HashMap<String, String> map = new HashMap<String, String> ();
    map.put("name", "소나타");
    map.put("maker", "현대자동차");
    request.setAttribute("car", map);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<ul>
<li> 이름 : ${customer.name } </li>
<li> E-mail : ${customer.email } </li>
<li> 번호 : ${customer.tel } </li>
</ul>
<ul>
<li>자동차 : ${car.name } </li>
<li>제조사 : ${car.maker } </li>
</ul>
</body>
</html>