package com.naver.reserve.controller;

import java.util.List;

import com.naver.reserve.dto.Product;
import com.naver.reserve.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naver.reserve.dto.Category;
import com.naver.reserve.service.CategoryService;
import com.naver.reserve.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping(path="/api")
public class ReserveApiController {

	private CategoryService categoryService;
	private ProductService productService;

	public ReserveApiController(CategoryServiceImpl categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("categories")
	public List<Category> getCategory() {
		System.out.println("getCategory");
		return categoryService.getCategory();
	}

	@GetMapping("products")
	public List<Product> getProduct(@RequestParam String categoryId) {
		System.out.println("categoryId : " + categoryId);

		return productService.getProduct(categoryId);
	}
}