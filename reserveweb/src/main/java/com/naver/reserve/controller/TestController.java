package com.naver.reserve.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("test")
	public ModelAndView test(ModelAndView mav) {
		mav.addObject("serverTime", DateFormat.getDateTimeInstance().format(new Date()));
		mav.setViewName("test");
		
		return mav;
	}
}
