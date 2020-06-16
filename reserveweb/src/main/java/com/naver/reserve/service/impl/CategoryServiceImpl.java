package com.naver.reserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dto.Category;
import com.naver.reserve.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getCategory() {
		return categoryDao.getCategory();
	}
}
