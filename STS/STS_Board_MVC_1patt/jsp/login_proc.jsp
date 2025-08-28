<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.user.impl.UserDAO"%>
<%@ page import="com.globalin.biz.user.UserVO"%>

<%
	// 1. 사용자 입력 정보를 추출
String id = request.getParameter("id");
String password = request.getParameter("password");

// 2. 데이터베이스를 연동
UserVO vo = new UserVO();
vo.setId(id);
vo.setPassword(password);

UserDAO userDAO = new UserDAO();
UserVO user = userDAO.getUser(vo);

// 3. 화면 네비게이션
if (user != null) { //로그인 성공
	response.sendRedirect("getBoardList.jsp");
} else { //로그인 실패
	response.sendRedirect("login.jsp");
} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>