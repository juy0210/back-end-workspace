package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.dao.MemberDAO;
import com.kh.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member!=null) {
			session.invalidate();
		}
		return new ModelAndView("index.jsp", true);
	}

}
