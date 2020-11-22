package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.ProductPriceDao;
import com.naver.reserve.dao.mapper.ProductPriceMapper;
import com.naver.reserve.dto.response.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductPriceDaoImpl implements ProductPriceDao {

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Override
    public List<ProductPrice> getProductPrice(int productId) {
        return productPriceMapper.selectProductPrice(productId);
    }
}
