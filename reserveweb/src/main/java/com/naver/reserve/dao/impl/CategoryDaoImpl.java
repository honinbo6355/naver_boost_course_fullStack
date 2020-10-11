package com.naver.reserve.dao.impl;

import java.util.List;

import com.naver.reserve.dto.response.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dao.mapper.CategoryMapper;
import com.naver.reserve.dto.response.CategoryResponseDto;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getCategory() {
		return categoryMapper.selectCategory();
	}
}
