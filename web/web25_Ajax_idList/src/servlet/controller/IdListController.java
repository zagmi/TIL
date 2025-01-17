package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("list", MemberDAOImpl.getInstance().showAllMember());
		return new ModelAndView("show_idList.jsp");
	}
	
}
