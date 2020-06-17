package com.naver.reserve.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naver.reserve.dto.Category;

@Mapper
public interface CategoryMapper {

	List<Category> selectCategory();
}
