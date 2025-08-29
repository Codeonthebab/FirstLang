package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그아웃 처리");
		
		HttpSession session = request.getSession();
		session.invalidate();

		//response.sendRedirect("login.jsp");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
		//return "login.jsp";
	}

}
