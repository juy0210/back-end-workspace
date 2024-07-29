package controller.component;

import java.sql.SQLException;

import org.springframework.web.servlet.mvc.Controller;

import com.kh.dao.MemberDAO;
import com.kh.vo.Member;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Member member = new Member(id, password, name);

		MemberDAO dao = new MemberDAO();

		return new ModelAndView("index.jsp", true);
	}
}








































