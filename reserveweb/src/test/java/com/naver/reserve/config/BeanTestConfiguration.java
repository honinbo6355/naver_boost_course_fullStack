package com.naver.reserve.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.naver.reserve.controller.ReserveApiController;
import com.naver.reserve.dao.CategoryDao;
import com.naver.reserve.dao.impl.CategoryDaoImpl;
import com.naver.reserve.dto.Category;
import com.naver.reserve.service.CategoryService;
import com.naver.reserve.service.impl.CategoryServiceImpl;

@Configuration
public class BeanTestConfiguration {

	@Bean("reserveApiController")
	public ReserveApiController reserveApiController() {
		return new ReserveApiController();
	}
	
	@Bean("categoryService")
	public CategoryService categoryService() {
		return new CategoryServiceImpl();
	}
	
	@Bean("categoryDao")
	public CategoryDao categoryDao() {
		return new CategoryDaoImpl();
	}
}
