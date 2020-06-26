package com.naver.reserve.service;

import com.naver.reserve.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProduct(String categoryId);
}
