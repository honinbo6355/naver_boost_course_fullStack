package com.naver.reserve.dao;

import com.naver.reserve.dto.response.ProductPrice;

import java.util.List;

public interface ProductPriceDao {
    List<ProductPrice> getProductPrice(int productId);
}
