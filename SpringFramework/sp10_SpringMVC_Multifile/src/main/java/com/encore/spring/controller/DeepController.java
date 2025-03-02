package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeepController {
	
	@RequestMapping("deep.do")
	public ModelAndView executeModel(HttpServletRequest req) {
		req.setAttribute("loss_plot", "upload/Loss.png");
		req.setAttribute("acc_plot", "upload/acc.png");
		return new ModelAndView("result");
	}
}
