package com.naver.reserve.dao;

import com.naver.reserve.dto.response.ProductImage;

import java.util.List;

public interface ProductImageDao {
    List<ProductImage> getProductImages(int productId);
}
