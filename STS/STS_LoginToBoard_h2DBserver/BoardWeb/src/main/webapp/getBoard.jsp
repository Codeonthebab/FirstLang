<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div align="center">
<h1>글 상세 보기</h1>
<a href="logout.do">Log-out</a>
<hr color="red">
<form action="updateBoard.do" method="post">
     <input type="hidden" name="seq" value="${board.seq}">
    <table border="1" cellpadding="0" cellspacing="0">
         <tr>
               <td bgcolor="orange" width="70">제목</td>
               <td align="left">
                    <input name="title" type="text" value="${board.title}">
               </td>
         </tr>
         
         <tr>
               <td bgcolor="orange" >작성자</td>
               <td align="left">
                    ${board.writer}
               </td>
         </tr>
         
            <tr>
               <td bgcolor="orange">내용</td>
               <td align="left">
                    <textarea rows="10" cols="40" name="content">${board.content}</textarea>
               </td>
         </tr>
         
          <tr>
               <td bgcolor="orange" >등록일</td>
               <td align="left">
                    ${board.regDate}
               </td>
         </tr>
         
          <tr>
               <td bgcolor="orange" >조회수</td>
               <td align="left">
                   ${board.cnt}
               </td>
         </tr>
         
         <tr>
             <td colspan="2" align="center">
                    <input type="submit" value="글수정">
             </td>
      </tr>
    </table>
</form>
<hr color="red">
   <a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
   <a href="deleteBoard.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
   <a href="getBoardList.do">글목록</a>
</div>
</body>
</html>