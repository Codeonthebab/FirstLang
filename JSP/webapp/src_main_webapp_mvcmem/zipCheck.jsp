<%@ page import="java.util.Vector, com.memberone.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/mvcmem/script.js"></script>
</head>
<body bgcolor="#ffffcc">
	<div align="center">
		<b> 우편번호 찾기 </b>
		<form action="member.mdo" method="post" name="zipForm">

			<table>
				<tr>
					<td>동 이름 입력 : <input type="text" name="dong"> <input
						type="button" value="검색" onclick="dongCheck()"></td>
				</tr>
			</table>
			<input type="hidden" name="cmd" value="zipcheck">
			<input type="hidden" name="check" value="n">
		</form>

		<table border="1">

			<c:if test="${check eq 'n' }">

				<c:if test="${zipcodeList.isEmpty() }">
					<tr>
						<td align="center"><br> 검색된 결과가 없습니다.</td>
					</tr>
				</c:if>

				<c:if test="${!zipcodeList.isEmpty() }">
					<tr>
						<td align="center"><br> ※ 검색 후 , 아래 우편번호를 클릭하면 자동으로
							입력됩니다.</td>
					</tr>

					<c:forEach var="vo" items="${zipcodeList }">
						<tr>
							<td align="left"><a
								href="javascript:sendAddress('${vo.getZipcode()}', '${vo.getSido()}', '${vo.getGugun()}','${vo.getDong()}','${vo.getRi()}','${vo.getBunji()}')">
								<br>
								${vo.getZipcode()}&nbsp;${vo.getSido()}&nbsp;${vo.getGugun()}&nbsp;${vo.getDong()}&nbsp;${vo.getRi()}&nbsp;${vo.getBunji()}</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>
		</table>
		<table>
			<tr>
				<td align="center"><a href="javascript:this.close()">닫기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>