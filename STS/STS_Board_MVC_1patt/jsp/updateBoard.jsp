<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>

<%
    // 1. 목록 페이지에서 보낸 게시글 번호(seq)를 URL로부터 받습니다.
    String seq = request.getParameter("seq");

    // 2. 받은 seq 번호를 BoardVO 객체에 설정합니다.
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));

    // 3. DAO 객체를 생성하고, seq 번호에 해당하는 게시글 하나만 조회합니다.
    BoardDAO boardDAO = new BoardDAO();
    BoardVO board = boardDAO.getBoardVO(vo); // getBoardList가 아닌 getBoardVO 사용
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 상세</title>
</head>
<body>
<div align="center">
    <h1>글 상세</h1>
    <a href="logout_proc.jsp">Log-out</a>
    <hr>
    <form action="updateBoard_proc.jsp" method="post">
        <input type="hidden" name="seq" value="<%= board.getSeq() %>" />
        
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">작성자</td>
                <%-- 작성자는 수정 불가 항목으로, 화면에 표시만 합니다. --%>
                <td align="left"><%= board.getWriter() %></td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
            </tr>
            <tr>
                <td bgcolor="orange">등록일</td>
                <td align="left"><%= board.getRegDate() %></td>
            </tr>
            <tr>
                <td bgcolor="orange">조회수</td>
                <td align="left"><%= board.getCnt() %></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="글 수정"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
    <a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="getBoardList.jsp">글 목록</a>
</div>
</body>
</html>