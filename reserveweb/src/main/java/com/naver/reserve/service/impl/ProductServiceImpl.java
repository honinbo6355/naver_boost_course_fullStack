package com.naver.reserve.service.impl;

import com.naver.reserve.dao.ProductDao;
import com.naver.reserve.dao.impl.ProductDaoImpl;
import com.naver.reserve.dto.Header;
import com.naver.reserve.dto.response.ProductResponseDto;
import com.naver.reserve.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public Header getProduct(String categoryId) {
        Header header = new Header();
        try {
            Map<String, Object> resultMap = new HashMap<>();
            List<ProductResponseDto> productList = productDao.getProduct(categoryId);
            resultMap.put("productList", productList);
            header.setData(resultMap);
            header.OK();
        } catch (Exception e) {
            e.printStackTrace();
            header.ERROR();
        }

        return header;
    }
}
