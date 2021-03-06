package com.naver.reserve.service.impl;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.*;
import com.naver.reserve.mapper.*;
import com.naver.reserve.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private DisplayInfoMapper displayInfoMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private DisplayInfoImageMapper displayInfoImageMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Override
    public ProductResponseDto getProduct(int categoryId, MoreViewRequestDto moreViewRequestDto) throws Exception {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setItems(productMapper.selectProduct(categoryId, moreViewRequestDto));
        productResponseDto.setTotalCount(productMapper.selectProductCount(categoryId));

        return productResponseDto;
    }

    @Override
    public DisplayInfoResponse getProductDetail(int displayInfoId) throws Exception {
        DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
        DisplayInfo displayInfo = displayInfoMapper.selectDisplayInfo(displayInfoId);
        int productId = displayInfo.getProductId();
        List<ProductImage> productImages = productImageMapper.selectProductImages(productId);
        DisplayInfoImage displayInfoImage = displayInfoImageMapper.selectDisplayInfoImage(displayInfoId);
        List<Comment> comments = commentMapper.selectComment(productId);
        Double averageScore = commentMapper.selectAverageScore(productId);

        displayInfoResponse.setDisplayInfo(displayInfo);
        displayInfoResponse.setProductImages(productImages);
        displayInfoResponse.setDisplayInfoImage(displayInfoImage);
        displayInfoResponse.setComments(comments);
        displayInfoResponse.setAverageScore(averageScore);

        return displayInfoResponse;
    }
}
