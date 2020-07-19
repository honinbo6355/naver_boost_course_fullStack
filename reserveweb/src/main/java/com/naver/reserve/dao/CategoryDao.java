package com.naver.reserve.dao;

import java.util.List;

import com.naver.reserve.dto.response.CategoryResponseDto;

public interface CategoryDao {

	List<CategoryResponseDto> getCategory();
}
