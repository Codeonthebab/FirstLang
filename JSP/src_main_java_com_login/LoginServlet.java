package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			HttpSession session = request.getSession(false);
			if (session != null) { // 로그인 정보가 존재했을 경우 (로그인을 성공했을 때)
				String sessionId = session.getId();
				System.out.println("세션 아이디 : " + sessionId);

				String user = (String) session.getAttribute("user");

				out.println("<html>");
				out.println("<body>");
				out.println("<table width = '300' border = '1'>");
				out.println("<tr>");
				out.println("<td width='300' style = 'text-align = center;'>" + user + "님 환영합니다. </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td align = 'center'>");
				out.println("<a href='#'> 회원정보 </a>");
				out.println("<a href='Log out'> 로그 아웃 </a>");
				out.println("<td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			} else { // 로그인이 아닌 경우
				out.println("<html>");
				out.println("<body>");
				out.println("<form method = 'post' action = 'LoginCheck'>");
				out.println("<table width = '300' border = '1'>");

				out.println("<tr>");
				out.println("<th width='100'> 아이디 </th>");
				out.println("<td width= '200'> &nbsp; <input type='text' name='id'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='100'> 비밀번호 </th>");
				out.println("<td width= '200'> &nbsp; <input type='password' name='pw'></td>");
				out.println("</tr>");

				// 벗튼 구성
				out.println("<tr>");
				out.println("<td colspan='2' align='center'>");
				out.println("<input type='button' value='회원가입'>");
				out.println("<input type='submit' value='로그인'>");
				out.println("</td>");
				out.println("</tr>");
			
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}
		} finally {
			out.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
