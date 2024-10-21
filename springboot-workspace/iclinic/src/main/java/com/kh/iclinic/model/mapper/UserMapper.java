package com.kh.iclinic.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.iclinic.model.vo.User;

@Mapper
public interface UserMapper {
	User loginUser(String id, String password);
}

