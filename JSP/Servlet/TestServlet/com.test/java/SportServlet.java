package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식에서의 한글 처리
		request.setCharacterEncoding("utf-8");
		String [] sports = request.getParameterValues("sports");
		String gender = request.getParameter("gender");
		
		// 응답할 때의 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html> <body>");
		for (String sport : sports) {
		out.println("좋아하는 운동은 "+sport+"<br>");
		}
		out.println("성별은 "+gender+"<br>");
		out.println("</body> </html>");
		
	}
}
