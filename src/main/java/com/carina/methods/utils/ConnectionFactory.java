package com.carina.methods.utils;

import com.carina.demo.db.mappers.UserMapper;
import com.carina.demo.db.mappers.UserPreferenceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ConnectionFactory {

	private static SqlSessionFactory factory;

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}

	public static UserMapper getUserMapper() {
		try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
			return sqlSession.getMapper(UserMapper.class);
		}
	}

	public static UserPreferenceMapper getUserPreferenceMapperMapper() {
		try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
			return sqlSession.getMapper(UserPreferenceMapper.class);
		}
	}

}
