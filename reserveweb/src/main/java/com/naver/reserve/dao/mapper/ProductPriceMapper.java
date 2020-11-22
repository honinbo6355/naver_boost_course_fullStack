package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.ProductPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductPriceMapper {
    List<ProductPrice> selectProductPrice(@Param("productId") int productId);
}
