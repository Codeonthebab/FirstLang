<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%

Connection con = null;
Statement stmt = null;
ResultSet rs = null;

int counter = 0;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "system";
	String password = "0000";

	con = DriverManager.getConnection(url, user, password);
	stmt = con.createStatement();
	rs = stmt.executeQuery("select * from tempmember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link href="People.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#303020">
	<h2>JSP 스크립트릿을 이용해서 데이터베이스 연동</h2>
	<h3>회원 정보</h3>
	<table bordercolor="#000fff" border="1">
		<tr>
			<td><strong>ID</strong></td>
			<td><strong>PASSWORD </strong></td>
			<td><strong>NAME</strong></td>
			<td><strong>MEM_NUM1</strong></td>
			<td><strong>MEM_NUM2</strong></td>
			<td><strong>E_MAIL</strong></td>
			<td><strong>PHONE</strong></td>
			<td><strong>ZIPCODE</strong></td>
			<td><strong>ADDRESS</strong></td>
			<td><strong>JOB</strong></td>
		</tr>


		<%
		if (rs != null) {
			while (rs.next()) {
		%>

		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("password")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("men_num1")%></td>
			<td><%=rs.getString("men_num2")%></td>
			<td><%=rs.getString("e_mail")%></td>
			<td><%=rs.getString("phone")%></td>
			<td><%=rs.getString("zipcode")%></td>
			<td><%=rs.getString("address")%></td>
			<td><%=rs.getString("job")%></td>
		</tr>
		<%
		//counter++;
		} // end while
		} // end of
		%>
	</table>
</body>
</html>

<%
} catch (Exception e) {
e.printStackTrace();
} finally {
	if (rs != null) try {rs.close();} catch (SQLException ss) {ss.printStackTrace(); }
	if (stmt != null) try{stmt.close();} catch (SQLException ss) {ss.printStackTrace();}
	if (con != null) try { con.close(); } catch (SQLException ss) { ss.printStackTrace();}
}
%>