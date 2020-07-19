package com.naver.reserve.service.impl;

import java.util.List;

import com.naver.reserve.dto.Header;
import org.springframework.stereotype.Service;

import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dao.impl.CategoryDaoImpl;
import com.naver.reserve.dto.response.CategoryResponseDto;
import com.naver.reserve.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	public CategoryServiceImpl(CategoryDaoImpl categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Header getCategory() {
		Header header = new Header();
		try {
			List<CategoryResponseDto> categories = categoryDao.getCategory();
			header.setData(categories);
			header.OK();
		} catch (Exception e) {
			e.printStackTrace();
			header.ERROR();
		}
		return header;
	}
}
