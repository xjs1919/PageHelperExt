package com.chrhc.mybatis.handler.mapper.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chrhc.mybatis.handler.domain.User;
import com.chrhc.mybatis.handler.mapper.UserMapper;
import com.github.pagehelper.PageInfo;

public class UserMapperTest {
	
	private static SqlSession sqlSession = null;
	
	@BeforeClass
	public static void doInitTest() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	@Test
	public void testSelect() throws Exception {
		User user = new User();
		user.setPageNum(1);
		user.setPageSize(2);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		PageInfo<User> pageinfo = userMapper.selectUser(user);
		System.out.println(pageinfo);
		List<User> users = pageinfo.getList();
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i));
		}
	}
}
