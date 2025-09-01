package com.globalin.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globalin.biz.user.UserService;
import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user")   UserVO vo) {
		System.out.println("로그인 화면으로 이동..");
		vo.setId("test");
		vo.setPassword("q1w2e3r4");
		return "login.jsp";
	}
	
	
	@RequestMapping(value ="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		     
		    UserVO user = userService.getUser(vo);
		    
		    if(user != null) {// 로그인 성공
		    	session.setAttribute("userName", user.getName());
		      return "getBoardList.do";
		    	
		     }else {// 로그인 실패
		    	return  "login.jsp";
		    }
		     
	}

}
