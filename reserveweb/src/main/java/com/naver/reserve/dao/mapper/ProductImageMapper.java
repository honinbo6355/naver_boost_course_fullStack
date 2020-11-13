package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.ProductImage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductImageMapper {

    ProductImage selectProductImage(int productId);
}
