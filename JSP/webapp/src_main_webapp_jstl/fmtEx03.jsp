<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
number : 
<fmt:formatNumber type = "number" value="1234.56"/> <br>
currency :
<fmt:formatNumber type = "currency" value="1234.56" currencySymbol="凸"/><br>
percent :
<fmt:formatNumber type = "percent" value="1234.56"/> <br>
pattern=".0"
<fmt:formatNumber pattern=".0" value="1234.56"/>

<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
<c:out value="${now }"/> <br>

date : <fmt:formatDate value="${now }" type="date" /> <br>
time : <fmt:formatDate value="${now }" type="time"/> <br>
both : <fmt:formatDate value="${now }" type="both"/><br>

</body>
</html>