package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String createController(HttpServletRequest req, HttpServletResponse res);
}
