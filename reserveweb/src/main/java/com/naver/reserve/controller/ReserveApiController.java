package com.naver.reserve.controller;

import java.util.List;

import com.naver.reserve.dto.Header;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.ProductResponseDto;
import com.naver.reserve.service.ProductService;
import com.naver.reserve.service.PromotionService;
import com.naver.reserve.service.impl.ProductServiceImpl;
import com.naver.reserve.service.impl.PromotionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naver.reserve.dto.response.CategoryResponseDto;
import com.naver.reserve.service.CategoryService;
import com.naver.reserve.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping(path="/api")
public class ReserveApiController {

	private CategoryService categoryService;
	private ProductService productService;
	private PromotionService promotionService;

	public ReserveApiController(CategoryServiceImpl categoryService, ProductServiceImpl productService, PromotionServiceImpl promotionService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.promotionService = promotionService;
	}

	@GetMapping("categories")
	public Header getCategories() {
		System.out.println("getCategories");
		return categoryService.getCategory();
	}

	@GetMapping("products")
	public Header getProducts(@RequestParam String categoryId, @RequestParam(defaultValue = "0") int start) {
		System.out.println("categoryId : " + categoryId);
		MoreViewRequestDto moreViewRequestDto = new MoreViewRequestDto(start);
		return productService.getProduct(categoryId, moreViewRequestDto);
	}

	@GetMapping("promotions")
	public Header getPromotions() {
		return promotionService.getPromotion();
	}
}
