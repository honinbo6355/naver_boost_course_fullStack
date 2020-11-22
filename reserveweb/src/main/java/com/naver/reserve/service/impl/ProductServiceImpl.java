package com.naver.reserve.service.impl;

import com.naver.reserve.dao.*;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.*;
import com.naver.reserve.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DisplayInfoDao displayInfoDao;

    @Autowired
    private ProductImageDao productImageDao;

    @Autowired
    private DisplayInfoImageDao displayInfoImageDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ProductPriceDao productPriceDao;

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
            List<ProductImage> productImages = productImageDao.getProductImages(productId);
            DisplayInfoImage displayInfoImage = displayInfoImageDao.getDisplayInfoImage(displayInfoId);
            List<Comment> comments = commentDao.getComment(productId);
            List<ProductPrice> productPrices = productPriceDao.getProductPrice(productId);

            displayInfoResponse.setDisplayInfo(displayInfo);
            displayInfoResponse.setProductImages(productImages);
            displayInfoResponse.setDisplayInfoImage(displayInfoImage);
            displayInfoResponse.setComments(comments);
            displayInfoResponse.setProductPrices(productPrices);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayInfoResponse;
    }
}
