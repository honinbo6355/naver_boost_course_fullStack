package com.naver.reserve.dao;

import com.naver.reserve.dto.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProduct(String categoryId);
}
