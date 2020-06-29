package com.naver.reserve.controller;

import java.util.List;

import com.naver.reserve.dto.Product;
import com.naver.reserve.service.ProductService;
import com.naver.reserve.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

	public ReserveApiController(CategoryServiceImpl categoryService, ProductServiceImpl productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping("categories")
	public List<Category> getCategories() {
		System.out.println("getCategories");
		return categoryService.getCategory();
	}

	@GetMapping("products")
	public List<Product> getProducts(@RequestParam String categoryId) {
		System.out.println("categoryId : " + categoryId);

		return productService.getProduct(categoryId);
	}
}
