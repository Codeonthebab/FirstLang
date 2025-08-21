package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvcmem.control.ActionForward;
import com.mvcmem.model.StudentDAO;

public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("utf-8");
		StudentDAO dao = StudentDAO.getInstance();
		HttpSession session = request.getSession();

		String loginID = (String) session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		int check = dao.deleteMember(loginID, pass);

		if (check != 0) {
			session.invalidate();
		}
		request.setAttribute("check", check);

		return new ActionForward("/mvcmem/deleteProc.jsp", false);
	}

}
