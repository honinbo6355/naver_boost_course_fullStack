package com.naver.reserve.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private Long userId;
	private String email;
	private String password;
}
