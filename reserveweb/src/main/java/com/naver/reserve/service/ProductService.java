package com.naver.reserve.service;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.ProductResponseDto;

import java.util.Map;

public interface ProductService {
    ProductResponseDto getProduct(String categoryId, MoreViewRequestDto moreViewRequestDto);
}
