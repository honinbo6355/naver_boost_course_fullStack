package com.naver.reserve.dao;

import com.naver.reserve.dto.response.ProductImage;

public interface ProductImageDao {
    ProductImage getProductImage(int productId);
}
