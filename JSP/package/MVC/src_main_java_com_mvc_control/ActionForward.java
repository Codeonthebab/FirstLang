package com.mvc.control;
/*  비즈니스 로직 수행 후, Servlet에서 반환하는 객체
 * 		- 이동할 url과 이동 방법을 저장함
 */

public class ActionForward {
	private String url;
	private boolean redirect;
	
	public ActionForward() {
	}
	
	// 오바라이드
	public ActionForward(String url) {
		this.url= url;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public ActionForward(String url, boolean redirect) {
		this.url= url;
		this.redirect = redirect;
	}
	
}
