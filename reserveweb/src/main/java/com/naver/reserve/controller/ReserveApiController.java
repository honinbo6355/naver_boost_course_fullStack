package com.naver.reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.reserve.dto.Category;
import com.naver.reserve.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class ReserveApiController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("categories")
	public List<Category> getCategory() {
		//System.out.println("getCategory");
		System.out.println(categoryService.getCategory());
		return null;
	}
}