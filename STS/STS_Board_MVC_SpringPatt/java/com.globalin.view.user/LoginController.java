package com.globalin.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그인 처리");

		// 1. 사용자 입력 정보를 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. 데이터베이스를 연동
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. 로그인 결과 값 분기
		ModelAndView mav = new ModelAndView();
		
		if (user != null) { //로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getName());
			mav.setViewName("redirect:getBoardList.do"); 
		} else { //로그인 실패
			mav.setViewName("login");
		} 
		return mav;
		
	}

}
