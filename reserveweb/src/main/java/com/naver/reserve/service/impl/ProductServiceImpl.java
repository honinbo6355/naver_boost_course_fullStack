package com.naver.reserve.service.impl;

import com.naver.reserve.dao.DisplayInfoDao;
import com.naver.reserve.dao.ProductDao;
import com.naver.reserve.dao.ProductImageDao;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.DisplayInfo;
import com.naver.reserve.dto.response.DisplayInfoResponse;
import com.naver.reserve.dto.response.ProductResponseDto;
import com.naver.reserve.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DisplayInfoDao displayInfoDao;

    @Autowired
    private ProductImageDao productImageDao;

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

    @Override
    public DisplayInfoResponse getProductDetail(int displayInfoId) {
        DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
        try {
            DisplayInfo displayInfo = displayInfoDao.getDisplayInfo(displayInfoId);
            int productId = displayInfo.getProductId();
            productImageDao.getProductImage(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayInfoResponse;
    }
}
