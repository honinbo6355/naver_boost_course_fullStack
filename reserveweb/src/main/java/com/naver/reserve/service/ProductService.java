package com.naver.reserve.service;

import com.naver.reserve.dto.Header;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    Header getProduct(String categoryId, MoreViewRequestDto moreViewRequestDto);
}
