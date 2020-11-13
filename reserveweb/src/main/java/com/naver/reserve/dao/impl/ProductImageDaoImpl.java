package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.ProductImageDao;
import com.naver.reserve.dao.mapper.ProductImageMapper;
import com.naver.reserve.dto.response.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImageDaoImpl implements ProductImageDao {

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public ProductImage getProductImage(int productId) {
        return productImageMapper.selectProductImage(productId);
    }
}
