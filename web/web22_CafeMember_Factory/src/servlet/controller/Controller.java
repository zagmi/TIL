package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
