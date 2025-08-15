package com.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.control.ActionForward;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 여기서는 특별한 로직 없이 main.jsp로 이동하라는 정보만 설정
        ActionForward forward = new ActionForward();

        // 이동 방식 설정 (true: redirect, false: forward)
        forward.setUrl("/mvc/index.jsp");
        forward.setRedirect(false); 
        
        // 설정된 ActionForward 객체를 반환
        return forward;
	}

}
