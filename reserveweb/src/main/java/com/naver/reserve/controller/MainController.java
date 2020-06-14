package com.naver.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("mainpage")
    public ModelAndView mainPage() {
        return new ModelAndView("mainpage");
    }
}
