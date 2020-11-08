package com.naver.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("mainpage")
    public ModelAndView mainPage() {
        return new ModelAndView("mainpage");
    }

    @GetMapping("detail")
    public ModelAndView detail() {
        return new ModelAndView("detail");
    }
}
