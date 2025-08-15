<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.boardone.BoardDAO"%>
<%@ page import="com.boardone.BoardVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="view/color.jsp"%>

<%!int pageSize = 5;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

<%
String pageNum = request.getParameter("pageNum");
if (pageNum == null) {
	pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;
int number = 0;
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");

int count = 0;
List<BoardVO> articleList = null;
BoardDAO dbPro = BoardDAO.getInstance();

if (searchWord != null && !searchWord.isEmpty()) {// 전체 글 가져오기
	count = dbPro.getArticleCount(searchField, searchWord);
	if (count > 0) {
		articleList = dbPro.getArticles(startRow, endRow, searchField, searchWord);
	}
} else {
	count = dbPro.getArticleCount();
	if (count > 0) { // 글이 존재할 경우
		articleList = dbPro.getArticles(startRow, endRow); // 글을 가져다가 아티클리스트에 저장
	}
}
number = count - (currentPage - 1) * pageSize;
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
		<b> 글 목록 (전체 글 : <%=count%>)
		</b>
		<table width="700">
			<tr>
				<td align="right" bgcolor="<%=value_color%>"><a
					href="writeForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		<%
		if (count == 0) {
		%>
		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
		<%
		} else {
		%>
		<table width="700" border="1" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" bgcolor="<%=value_color%>">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조회</td>
				<td align="center" width="10">IP</td>
			</tr>
			<%
			for (int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO) articleList.get(i);
			%>
			<tr height="30">
				<td align="center" width="50"><%=number--%></td>
				<td width="250">
					<%
					if (article.getDepth() > 0) {
						int wid = 10 * (article.getDepth());
					%> <img src="<%=request.getContextPath()%>/Images/level.gif"
					width="<%=wid%>" height="16"> <img
					src="<%=request.getContextPath()%>/Images/re.gif"> <%
 }
 %> <a
					href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
						<%=article.getSubject()%>
				</a> <%
 if (article.getReadcount() >= 5) {
 %> <img
					src="<%=request.getContextPath()%>/Images/hot.gif" border="0"
					height="16"> <%
 }
 %>
				</td>
				<td align="center" width="100"><a
					href="mailto:<%=article.getEmail()%>"> <%=article.getWriter()%>
				</a></td>
				<td align="center" width="150"><%=sdf.format(article.getRegdate())%>
				</td>
				<td align="center" width="50"><%=article.getReadcount()%></td>
				<td align="center" width="100"><%=article.getIp()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>

		<%
		if (count > 0) {
			int pageBlock = 5;
			int imsi = count % pageSize == 0 ? 0 : 1;
			int pageCount = count / pageSize + imsi;

			int startPage = (int) ((currentPage - 1) / pageBlock) * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;

			if (startPage > pageBlock) {
		%>
		<a href="list.jsp?pageNum=<%=startPage - 1%><%if (searchWord != null){%>&searchField=<%=searchField%>&searchWord=<%=searchWord%><%}%>"> [이전] </a>
		<%
		} // end [이전] if
		for (int i = startPage; i <= endPage; i++) {
		%>
		 <a href="list.jsp?pageNum=<%=i%><% if (searchWord != null) {%>&searchField=<%=searchField%>&searchWord=<%=searchWord%><%}%>"> [<%=i%>] </a>
		<%
		} // end for
		if (endPage < pageCount) {
		%>
		<a href="list.jsp?pageNum=<%=endPage+1%><% if (searchWord != null) { %>&searchField=<%=searchField%>&searchWord=<%=searchWord%><%}%>"> [다음] </a>
		<%
		} // end [다음] if
		}
		%>
		<form action="list.jsp" method="get">
			<select name="searchField">
				<option value="subject">제목</option>
				<option value="writer">작성자</option>
				<option value="content">내용</option>
			</select> 
			<input name="searchWord" size="20"> <input type="submit" value="검색">
		</form>


	</div>
</body>
</html>