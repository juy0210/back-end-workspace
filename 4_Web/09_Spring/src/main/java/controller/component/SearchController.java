package controller.component;

import com.kh.dao.MemberDAO;
import com.kh.vo.Member;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		Member member = dao.search(id);
		
		if (member != null) {

			request.setAttribute("member", member);
			return new ModelAndView ("/views/search_ok.jsp");
		}
		return new ModelAndView("/views/search_fail.jsp", true);
	}

}
