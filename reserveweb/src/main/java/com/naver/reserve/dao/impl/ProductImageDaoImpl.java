package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.ProductImageDao;
import com.naver.reserve.dao.mapper.ProductImageMapper;
import com.naver.reserve.dto.response.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductImageDaoImpl implements ProductImageDao {

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> getProductImages(int productId) {
        return productImageMapper.selectProductImages(productId);
    }
}
