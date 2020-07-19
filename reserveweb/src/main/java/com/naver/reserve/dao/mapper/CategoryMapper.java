package com.naver.reserve.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naver.reserve.dto.response.CategoryResponseDto;

@Mapper
public interface CategoryMapper {

	List<CategoryResponseDto> selectCategory();
}
