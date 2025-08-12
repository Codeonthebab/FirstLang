package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*	[페이지 이동 방식]
 *  - 메소드 호출을 통해서 페이지를 이동할 수 있는 방법 (두 가지)
 *  
 *  ** forward 방법과 redirect 방식 **
 *    ------------------------------------------------------------
 *    구분            			       forward                     redirect
 *    url						|   url이 바꾸지 않는다.     |    url이 바뀐다.
 *    요청 객체와 응답 객체	|      유지된다               |   유지되지 않는다.
 *    속도						|   	빠르다.				   |       느리다.
 *    소속 					|     request			   |     response
 */

@WebServlet("/Source")
public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("Source Start ...");
		
		// 1. forward 방식으로 페이지 이동
		//RequestDispatcher view = request.getRequestDispatcher("Destination");
		//view.forward(request, response);
		
		// 2. redirect 방식으로 페이지 이동
		response.sendRedirect("Destination");
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
