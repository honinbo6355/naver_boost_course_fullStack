package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductImageMapper {

    ProductImage selectProductImage(@Param("productId") int productId);
}
