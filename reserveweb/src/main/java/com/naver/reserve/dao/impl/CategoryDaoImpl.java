package com.naver.reserve.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dao.mapper.CategoryMapper;
import com.naver.reserve.dto.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getCategory() {
		return null;
	}
}
