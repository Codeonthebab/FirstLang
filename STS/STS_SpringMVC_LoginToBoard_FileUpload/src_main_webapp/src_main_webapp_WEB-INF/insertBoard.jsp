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
<h1>글 등록</h1>
<a href="logout.do">Log-out</a>
<hr color="red">
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
    <table border="1" cellpadding="0" cellspacing="0">
         <tr>
               <td bgcolor="orange" width="70">제목</td>
               <td align="left">
                    <input name="title" type="text">
               </td>
         </tr>
         
         <tr>
               <td bgcolor="orange" >작성자</td>
               <td align="left">
                    <input name="writer" type="text" size="10">
               </td>
         </tr>
         
            <tr>
               <td bgcolor="orange">내용</td>
               <td align="left">
                    <textarea rows="10" cols="40" name="content"></textarea>
               </td>
         </tr>
         
         <tr>
         <td bgcolor="orange" width="70"> 파일 업로드 </td>
         <td align="left">
         <input type="file" name="uploadFile"></td>
         </tr>
         
         <tr>
             <td colspan="2" align="center">
                    <input type="submit" value="새글 등록">
             </td>
      </tr>
    </table>
</form>
<hr color="red">
   <a href="getBoardList.do">글목록</a>
</div>
</body>
</html>