package com.naver.reserve.service.impl;

import com.naver.reserve.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.reserve.dto.response.CategoryResponseDto;
import com.naver.reserve.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public CategoryResponseDto getCategory() {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		try {
			categoryResponseDto.setItems(categoryMapper.selectCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryResponseDto;
	}
}
