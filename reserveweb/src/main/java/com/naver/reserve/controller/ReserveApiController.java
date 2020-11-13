package com.naver.reserve.controller;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.DisplayInfoResponse;
import com.naver.reserve.dto.response.ProductResponseDto;
import com.naver.reserve.dto.response.PromotionResponseDto;
import com.naver.reserve.service.ProductService;
import com.naver.reserve.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.naver.reserve.dto.response.CategoryResponseDto;
import com.naver.reserve.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class ReserveApiController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private PromotionService promotionService;

	@GetMapping("categories")
	public CategoryResponseDto getCategories() {
		System.out.println("getCategories");
		return categoryService.getCategory();
	}

	@GetMapping("products")
	public ProductResponseDto getProducts(@RequestParam int categoryId, @RequestParam(defaultValue = "0") int start) {
		MoreViewRequestDto moreViewRequestDto = new MoreViewRequestDto(start);
		return productService.getProduct(categoryId, moreViewRequestDto);
	}

	@GetMapping("products/{displayInfoId}")
	public DisplayInfoResponse getProductsDetail(@PathVariable("displayInfoId") int displayInfoId) {
		return productService.getProductDetail(displayInfoId);
	}

	@GetMapping("promotions")
	public PromotionResponseDto getPromotions() {
		return promotionService.getPromotion();
	}
}
