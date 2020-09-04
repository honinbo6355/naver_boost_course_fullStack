package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.ProductResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductResponseDto> selectProduct(@Param("categoryId") String categoryId, @Param("moreViewRequestDto") MoreViewRequestDto moreViewRequestDto);

    int selectProductCount(@Param("categoryId") String categoryId);
}
