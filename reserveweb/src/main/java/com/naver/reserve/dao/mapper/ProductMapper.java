package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.ProductResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductResponseDto> selectProduct(@Param("categoryId") String categoryId);
}
