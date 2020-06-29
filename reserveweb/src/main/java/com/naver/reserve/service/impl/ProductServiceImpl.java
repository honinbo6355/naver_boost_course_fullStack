package com.naver.reserve.service.impl;

import com.naver.reserve.dao.ProductDao;
import com.naver.reserve.dao.impl.ProductDaoImpl;
import com.naver.reserve.dto.Product;
import com.naver.reserve.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProduct(String categoryId) {
        return productDao.getProduct(categoryId);
    }
}
