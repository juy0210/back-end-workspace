package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.dao.MemberDAO;
import com.kh.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
        String password = request.getParameter("password");
       
        MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, password);

		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return new ModelAndView("index.jsp", true);
	}

}
