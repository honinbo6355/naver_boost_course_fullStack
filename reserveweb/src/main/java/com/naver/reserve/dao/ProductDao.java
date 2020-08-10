package com.naver.reserve.dao;

import com.naver.reserve.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductDao {

    List<ProductResponseDto> getProduct(String categoryId);

    int getProductCount(String categoryId);
}
