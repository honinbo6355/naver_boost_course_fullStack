package com.naver.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("mainpage")
    public ModelAndView mainPage() {
        return new ModelAndView("mainpage");
    }

    @GetMapping("detail/{displayInfoId}")
    public ModelAndView detail(@PathVariable("displayInfoId") int displayInfoId) {
        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("displayInfoId", displayInfoId);

        return mav;
    }

    @GetMapping("review/{displayInfoId}")
    public ModelAndView review(@PathVariable("displayInfoId") int displayInfoId) {
        ModelAndView mav = new ModelAndView("review");
        mav.addObject("displayInfoId", displayInfoId);

        return mav;
    }

    @GetMapping("reserve/{displayInfoId}")
    public ModelAndView reserve(@PathVariable("displayInfoId") int displayInfoId) {
        ModelAndView mav = new ModelAndView("reserve");
        mav.addObject("displayInfoId", displayInfoId);

        return mav;
    }

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginPage", true);

        return mav;
    }
}
