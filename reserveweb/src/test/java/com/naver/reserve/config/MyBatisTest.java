package com.naver.reserve.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MyBatisTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
        
    }
	
	@Test
	public void connectionTest() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
