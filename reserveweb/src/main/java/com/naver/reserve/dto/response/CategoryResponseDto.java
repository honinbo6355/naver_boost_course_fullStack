package com.naver.reserve.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryResponseDto {
	private List<Category> items;
}
