<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.boardone.BoardDAO"%>
<%@ page import="com.boardone.BoardVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="view/color.jsp"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

BoardDAO dbPro = BoardDAO.getInstance();
BoardVO article = dbPro.getArticle(num);

if (article == null) {
	out.println("<script>alert('삭제되었거나 존재하지 않는 게시물입니다.'); history.go(-1);</script>");
} else {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="<%=bodyback_color%>">
	<div align="center">
		<b>글 상세 보기</b> <br>
		<form action="">
			<table width="500" border="1" cellpadding="0" cellspacing="0"
				align="center" bgcolor="<%=bodyback_color%>">
				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_color%>">글번호</td>
					<td align="center" width="125"><%=article.getNum()%></td>
					<td align="center" width="125" bgcolor="<%=value_color%>">조회수</td>
					<td align="center" width="125"><%=article.getReadcount()%></td>
				</tr>
				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_color%>">작성자</td>
					<td align="center" width="125"><%=article.getWriter()%></td>
					<td align="center" width="125" bgcolor="<%=value_color%>">작성일</td>
					<td align="center" width="125"><%=sdf.format(article.getRegdate())%></td>
				</tr>
				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_color%>">글제목</td>
					<td align="left" width="375" colspan="3"><%=article.getSubject()%></td>
				</tr>
				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_color%>">글내용</td>
					<td align="left" width="375" colspan="3"><pre><%=article.getContent()%></pre></td>
				</tr>
				<tr height="30">
					<td colspan="4" bgcolor="<%=value_color%>" align="right"><input
						type="button" value="글수정"
						onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
						<input type="button" value="글삭제"
						onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
						<input type="button" value="답변쓰기"
						onclick="document.location.href='writeForm.jsp?num=<%=article.getNum()%>&ref=<%=article.getRef()%>&step=<%=article.getStep()%>&depth=<%=article.getDepth()%>&pageNum=<%=pageNum%>'">
						<input type="button" value="글목록"
						onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
<%
}
%>