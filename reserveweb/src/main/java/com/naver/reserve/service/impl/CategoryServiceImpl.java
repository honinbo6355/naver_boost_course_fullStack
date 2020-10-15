package com.naver.reserve.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.naver.reserve.dto.response.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dao.impl.CategoryDaoImpl;
import com.naver.reserve.dto.response.CategoryResponseDto;
import com.naver.reserve.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public CategoryResponseDto getCategory() {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		try {
			categoryResponseDto.setItems(categoryDao.getCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryResponseDto;
	}
}
