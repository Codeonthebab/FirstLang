<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Form</title>
</head>
<body>
폼에 데이터를 입력한 후, '전송' 버튼을 클릭하세요.
<form action = "viewParameter.jsp" method = "post"> 
이름 : <input type="text" name = "name" size="10"> <br>
주소 : <input type="text" name = "address" size="30"> <br>
동물<br> 
<input type="checkbox" name = "pet" size="dog"> 고양이
<input type="checkbox" name = "pet" size="dog"> 강아지
<input type="checkbox" name = "pet" size="dog"> 버피
<br> 
<input type = "submit" value = "전송"></form>
<table>
</table>
</body>
</html>