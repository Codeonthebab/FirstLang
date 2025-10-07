package com.globalin.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.globalin.view")
public class CommonExceptionHandler {
	
	//@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handlerArithemeticException (Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("Exception", e);
		mav.setViewName("/common/arithemeticError.jsp");
		return mav;
	}
	
	//@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlerNullPointerException (Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("Exception", e);
		mav.setViewName("/common/NullPointerError.jsp");
		return mav;
	}
	
	//@ExceptionHandler(Exception.class)
	public ModelAndView handlerException (Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("Exception", e);
		mav.setViewName("/common/Error.jsp");
		return mav;
	}
	
}