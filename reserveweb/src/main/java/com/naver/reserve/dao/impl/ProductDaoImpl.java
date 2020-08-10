package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.ProductDao;
import com.naver.reserve.dao.mapper.ProductMapper;
import com.naver.reserve.dto.response.ProductResponseDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> getProduct(String categoryId) {
        return productMapper.selectProduct(categoryId);
    }

    @Override
    public int getProductCount(String categoryId) {
        return productMapper.selectProductCount(categoryId);
    }
}
