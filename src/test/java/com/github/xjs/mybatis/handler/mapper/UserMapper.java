package com.github.xjs.mybatis.handler.mapper;

import com.github.pagehelper.PageInfo;
import com.github.xjs.mybatis.handler.domain.User;

public interface UserMapper {
	
	Integer insertUser(User user);

	PageInfo<User> selectUser(User user);
	
}
