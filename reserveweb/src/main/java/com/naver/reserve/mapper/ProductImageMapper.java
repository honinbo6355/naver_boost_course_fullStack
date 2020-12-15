package com.naver.reserve.mapper;

import com.naver.reserve.dto.response.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductImageMapper {

    List<ProductImage> selectProductImages(@Param("productId") int productId);
}
