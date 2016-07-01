package com.chrhc.mybatis.handler.mapper;

import com.chrhc.mybatis.handler.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserMapper {
	
	Integer insertUser(User user);

	PageInfo<User> selectUser(User user);
	
}
