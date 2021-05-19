package com.naver.reserve.mapper;

import com.naver.reserve.entity.Authority;
import com.naver.reserve.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface UserMapper {
	User selectUser(String email);

	void insertUser(User user);

	void insertAuthority(Authority authority);

	Set<String> selectAuthority(Long userId);
}
