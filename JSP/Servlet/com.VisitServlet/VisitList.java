package com.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/VisitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		try {
			out.println("<html>");
			out.println("<head><title> 방명록 </title></head>");
			out.println("<body style text align = center text-color = black>");
			out.println("<style>");
			out.println("  body { margin: 0; text-align: center; font-family: sans-serif; }");
			out.println("  header { background-color: black; color: white; padding: 20px; }");
			out.println("  header h1 { margin: 0; font-size: 24px; }");
			out.println("  table { border-collapse: collapse; margin: 20px auto; }");
			out.println("  th, td { padding: 8px; }");
			out.println("  a { text-decoration: none; color: blue; font-weight: bold; }");
			out.println("</style>");
			out.println("</style>");
			out.println("<header>");
			out.println("  <h1>방명록</h1>");
			out.println("</header>");

			String sql = "select no, writer, memo, regdate from VISIT " + "order by no desc";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pass = "tiger";

				con = DriverManager.getConnection(url, user, pass);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					int no = rs.getInt("no");
					String writer = rs.getString("writer");
					String memo = rs.getString("memo");
					Date regdate = rs.getDate("regdate");

					out.println("<table align = center width = 500 border=1>");
					out.println("<tr>");
					out.println("<th width=50 style='text-align : center;'> 번호 </th><br/>");
					out.println("<td width=50 style='text-align : center;'>" + no + "</td>");

					out.println("<th width=70  style='text-align : center;'> 작성자 </th>");
					out.println("<td width=180 style='text-align : center;'>" + writer + "</td>");
					
					out.println("<th width=70  style='text-align : center;'> 날짜 </th>");
					out.println("<td width=180 style='text-align : center;'>" + regdate + "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<th width=70  style='text-align : center;'> 내용 </th>");
					out.println("<td colspan='5'><textarea readonly rows='3' style='width: 98%; border: none;'>" + memo + "</textarea></td>");
					out.println("</tr>");
					
					out.println("</table>");
					out.println("<p>");
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
				try {
					if (pstmt != null)
						pstmt.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			}

			out.println("<p align = center text-color = red><a href=/bbs/write.html> 글 쓰기 </a></p>");
			out.println("</body>");
			out.println("</html>");
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
