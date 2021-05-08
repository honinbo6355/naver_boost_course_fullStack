package com.naver.reserve.service;

import com.naver.reserve.entity.User;

public interface UserService {
    User signup(User user) throws Exception;
}
