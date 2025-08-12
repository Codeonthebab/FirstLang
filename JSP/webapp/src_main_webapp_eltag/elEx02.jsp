<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.actiontag.*, java.util.*" %>
    <%
    ArrayList<String> singer = new ArrayList<String> ();
    singer.add("에스파");
    singer.add("프로미스나인");
    request.setAttribute("singer", singer);
    
    Customer[] customer = new Customer[2];
    customer[0] = new Customer();
    customer[0].setName("조해흠");
    customer[0].setEmail("johae@naver.com");
    customer[0].setTel("010-0000-0000");
        
    customer[1] = new Customer();
    customer[1].setName("길참참");
    customer[1].setEmail("chamuchamu@naver.com");
    customer[1].setTel("010-2222-2222");
    request.setAttribute("customer", customer);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul><li>${singer[0]}, ${singer[1] }</li></ul>

<ul>
<li> 이름 : ${customer[0].name }</li>
<li> 메일 : ${customer[0].email }</li>
<li> 번호 : ${customer[0].tel }</li>
</ul>

<ul>
<li> 이름 : ${customer[1].name }</li>
<li> 메일 : ${customer[1].email }</li>
<li> 번호 : ${customer[1].tel }</li>
</ul>

</body>
</html>