<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="true" info="Copyright 2025 by Menhera"
    import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>body{text-align: center; color:pink;text-shadow:2px 2px 5px #aaaaaa;}</style>
</head>
<body>
<% for (int i = 0; i<10; i++) { %>
	해흠, 사랑해
<%} String tagline = "지금 몇시일까요오오";%>
<hr color = "red">
<div class="container mt-3">
        <h2>미리 디자인된 버튼</h2>
        <button type="button" class="btn btn-primary">Primary 버튼</button>
        <button type="button" class="btn btn-success">Success 버튼</button>
    </div>
<br><br>
<%=getServletInfo() %>
<h3> <%=tagline%></h3>
<%Date day = new Date ();
String am_pm;

int hour = day.getHours();
int minute = day.getMinutes();
int second = day.getSeconds();
if (hour / 12==0) {am_pm = "AM";} else { am_pm="PM"; hour = hour - 12;}
String CT = hour+" : "+minute+ " : "+second+ " " +am_pm;
out.println("현재 접속 시간 : " +CT+ "\n");
%>
</body>
</html>