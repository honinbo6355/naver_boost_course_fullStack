package com.naver.reserve.dao.mapper;

import java.util.List;

import com.naver.reserve.dto.response.Category;
import org.apache.ibatis.annotations.Mapper;

import com.naver.reserve.dto.response.CategoryResponseDto;

@Mapper
public interface CategoryMapper {

	List<Category> selectCategory();
}
