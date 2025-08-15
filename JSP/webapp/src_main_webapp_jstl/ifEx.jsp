<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${3>4 }"> 이 내용은 화면에 출력하지 않습니다.</c:if> <!-- 파라미터 uri 예시를 들면  ifEx.jsp?type=guest 식으로-->
	<c:if test="${param.type eq'guest' }">홈페이지 방문을 환영합니다.<br> 더 나은 서비스를 이용하시려면 회원가입을 하시길 바랍니다. </c:if>
	<c:if test="${param.type eq'member' }">회원님을 방문을 환영합니다. <br> 보다 나은 서비스로 보답하겠습니다. <br> 즐거운 시간 되시길 바랍니다. </c:if>
</body>
</html>