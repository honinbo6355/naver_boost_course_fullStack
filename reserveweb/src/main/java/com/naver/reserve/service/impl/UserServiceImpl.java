package com.naver.reserve.service.impl;

import com.naver.reserve.entity.Authority;
import com.naver.reserve.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naver.reserve.mapper.UserMapper;
import com.naver.reserve.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(rollbackFor = Exception.class)
	public void signup(User user) throws Exception {
		if (userMapper.selectUser(user.getEmail()) != null) {
			throw new Exception("이미 가입되어 있는 유저입니다.");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.insertUser(user);

		Authority authority = new Authority();
		authority.setUserId(user.getUserId());
		authority.setAuthorityName("ROLE_USER");

		userMapper.insertAuthority(authority);
	}
}
