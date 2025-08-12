<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 가입</title>
</head>
<body align = center>
<form action="add.jsp" method="post">
<table width="500" border="1">
<tr>
<td width="200"> 이름 </td>
<td width="300"><input type="text" name="name" size="40"> </td>
</tr>
<tr>
<td width="200"> 이메일 </td>
<td width="300"><input type="text" name="email" size="40"> </td>
</tr>
<tr>
<td width="200"> 전화번호 </td>
<td width="300"><input type="text" name="tel" size="40"> </td>
</tr>
<tr>
<td width="200"> 생년월일 </td>
<td width="300"><input type="text" name="birth" size="40"> </td>
</tr>

<tr>
<td colspan = "2"><input type="submit" value = "가입"></td>
</tr>

</table>
</form>

</body>
</html>