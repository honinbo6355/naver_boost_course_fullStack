package com.naver.reserve.controller;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.response.*;
import com.naver.reserve.service.ProductService;
import com.naver.reserve.service.PromotionService;
import com.naver.reserve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	private ReservationService reservationService;

	@GetMapping("categories")
	public ResponseEntity<CategoryResponseDto> getCategories() {
		System.out.println("getCategories");
		ResponseEntity<CategoryResponseDto> response = null;
		try {
			response = new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping("products")
	public ResponseEntity<ProductResponseDto> getProducts(@RequestParam int categoryId, @RequestParam(defaultValue = "0") int start) {
		ResponseEntity<ProductResponseDto> response = null;
		try {
			MoreViewRequestDto moreViewRequestDto = new MoreViewRequestDto(start);
			response = new ResponseEntity<>(productService.getProduct(categoryId, moreViewRequestDto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping("products/{displayInfoId}")
	public ResponseEntity<DisplayInfoResponse> getProductsDetail(@PathVariable("displayInfoId") int displayInfoId) {
		ResponseEntity<DisplayInfoResponse> response = null;
		try {
			response = new ResponseEntity<>(productService.getProductDetail(displayInfoId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping("promotions")
	public ResponseEntity<PromotionResponseDto> getPromotions() {
		ResponseEntity<PromotionResponseDto> response = null;
		try {
			response = new ResponseEntity<>(promotionService.getPromotion(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping("reserve/{displayInfoId}")
	public ResponseEntity<ReservationResponse> getReservePageInfo(@PathVariable("displayInfoId") int displayInfoId) {
		ResponseEntity<ReservationResponse> response = null;
		try {
			response = new ResponseEntity<>(reservationService.getReservePageInfo(displayInfoId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@PostMapping("reserve")
	public ResponseEntity<Integer> createReservation(@RequestBody ReservationParam reservationParam) {
		ResponseEntity<Integer> response = null;
		try {
			reservationService.createReservation(reservationParam);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
