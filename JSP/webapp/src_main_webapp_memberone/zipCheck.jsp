<%@ page import="java.util.Vector, com.memberone.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.memberone.StudentDAO" />
<%
    request.setCharacterEncoding("utf-8");
    String check = request.getParameter("check");
    String dong = request.getParameter("dong");
    Vector <ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);
    
    int totalList = zipcodeList.size();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#ffffcc">
	<div align="center">
		<b> 우편번호 찾기 </b>
		<form action="zipCheck.jsp" method="post" name="zipForm">

			<table>
				<tr>
					<td>동 이름 입력 : <input type="text" name="dong"> <input
						type="button" value="검색" onclick="dongCheck()"></td>
				</tr>
			</table>
			<input type = "hidden" name = "check" value="n">
			</form>
			<table>
				<%

if(check.equals("n")) {
	if(zipcodeList.isEmpty()){
%>
				<tr>
					<td align="center"><br> 검색된 결과가 없습니다.</td>
				</tr>

				<%
	}else {
%>
				<tr>
					<td align="center"><br> # 검색 후 , 아래 우편번호를 클릭하면 자동으로
						입력됩니다.</td>
				</tr>
				<%
		for (int i = 0; i < totalList; i++) {
	ZipCodeVO vo = zipcodeList.elementAt(i);
	String tZipcode = vo.getZipcode();
	String tSido = vo.getSido();
	String tGugun = vo.getGugun();
	String tDong = vo.getDong();
	String tRi = vo.getRi();
	String tBunji = vo.getBunji();
	
	if(tRi == null) tRi="";
	if(tBunji == null) tBunji ="";
%>
<tr> <td>
<a href="javascript:sendAddress('<%=tZipcode%>','<%=tSido%>','<%=tGugun%>','<%=tDong%>', '<%=tRi%>', '<%=tBunji%>')">
<%=tZipcode%>&nbsp;<%=tSido%>&nbsp;<%=tGugun%>&nbsp;<%=tDong%>&nbsp;<%=tRi%>&nbsp;<%=tBunji%>
</a>
<br>
</td></tr>
<%
		} // end for
} // end else
} // end if
%>


			</table>
			<table>
				<tr>
					<td align="center"><a href="javascript:this.close()">닫기</a></td>
				</tr>
			</table>

		
	</div>
</body>
</html>