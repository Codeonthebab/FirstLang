package com.globalin.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring container 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring container로부터 UserServiceImpl 객체를 요청함
		UserService userService =
				(UserService)container.getBean("userService");
		
		// 3. 로그인 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"님 환영합니다.");
		}else {
			System.out.println("로그인 실패 !!!");
		}
		
		// 4. Spring  Container 종료
		container.close();
		
		
	}

}
