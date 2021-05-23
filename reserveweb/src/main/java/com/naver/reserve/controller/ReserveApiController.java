package com.naver.reserve.controller;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.response.*;
import com.naver.reserve.entity.User;
import com.naver.reserve.jwt.JwtFilter;
import com.naver.reserve.jwt.TokenProvider;
import com.naver.reserve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	private UserService userService;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

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
	public ResponseEntity<String> createReservation(@RequestBody ReservationParam reservationParam) {
		ResponseEntity response = null;
		try {
			reservationService.createReservation(reservationParam);
			response = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@PostMapping("signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		ResponseEntity response = null;
		try {
			userService.signup(user);
			response = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@PostMapping("doLogin")
	public ResponseEntity<String> doLogin(@RequestBody User user) {
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.createToken(authentication);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

		return new ResponseEntity(HttpStatus.OK, httpHeaders, HttpStatus.OK);
	}
}
