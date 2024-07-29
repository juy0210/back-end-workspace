package controller.component;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.dao.MemberDAO;
import com.kh.vo.Member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AllMemberController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.all();

		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp");
	}

}
