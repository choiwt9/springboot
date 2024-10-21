package com.kh.iclinic.service;

import org.springframework.stereotype.Service;

import com.kh.iclinic.model.mapper.UserMapper;
import com.kh.iclinic.model.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	
	
	private final UserMapper mapper;
	
	public User loginUser(User user) {
		return mapper.loginUser(user.getId(), user.getPassword());
	}
	
}
