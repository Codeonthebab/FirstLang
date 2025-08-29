<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Login </title>
</head>
<body>
<div className="real" align="center">
<h1 style="{text-align: center}"> Log in </h1>
<form action="login.do" method="post" >
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td bgcolor="orange"> 아이디 </td>
<td><input type="text" name="id"></td>
</tr>

<tr>
<td bgcolor="orange"> 비밀번호 </td>
<td><input type="password" name="password"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="로그인">
</td>
</tr>

</table>
</form>
</div>
</body>
</html>