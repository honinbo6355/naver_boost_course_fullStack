package com.naver.reserve.mapper;

import java.util.Optional;

import com.naver.reserve.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	User selectUser(String email);

	void insertUser(User user);
}
