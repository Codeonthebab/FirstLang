<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<meta http-equiv="refresh" content="1;url=member.mdo?cmd=login">
</head>

<body><c:set var="check" value="${check}"/>
<div align="center">

<c:if test="${check eq 0}">
<script type="text/javascript">
alert("비밀번호가 맞지 않습니다.");
history.go(-1);
</script>
</c:if>

<font size = "5" face = "MS Mincho">
<b>회원정보가 <span style="color : red;">삭제</span> 되었습니다.</b><br>
안녕히 가십시오. <br>
</font>
</div>
</body>
</html>