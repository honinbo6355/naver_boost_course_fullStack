package com.naver.reserve.service.impl;

import com.naver.reserve.dao.ProductDao;
import com.naver.reserve.dao.impl.ProductDaoImpl;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.Product;
import com.naver.reserve.dto.response.ProductResponseDto;
import com.naver.reserve.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductResponseDto getProduct(int categoryId, MoreViewRequestDto moreViewRequestDto) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        try {
            productResponseDto.setItems(productDao.getProduct(categoryId, moreViewRequestDto));
            productResponseDto.setTotalCount(productDao.getProductCount(categoryId));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productResponseDto;
    }
}
