package com.vintage.mapper;

import com.vintage.model.Country;
import com.vintage.model.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {
	private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            List<Country> countryList = sqlSession.selectList("select");
            printCountryList(countryList);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
    
    @Test
    public void testSelectUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            List<User> userList = sqlSession.selectList("selectuser");
            printUserList(userList);
        } finally {
            sqlSession.close();
        }
    }

    private void printUserList(List<User> userList) {
        for (User user : userList) {
            System.out.printf("%-4s%4s%4s\n", user.getEmail(), user.getPassword(), user.getLastName());
        }
    }
    
}
