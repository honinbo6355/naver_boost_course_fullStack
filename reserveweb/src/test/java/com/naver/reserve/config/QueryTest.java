package com.naver.reserve.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naver.reserve.controller.ReserveApiController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, BeanTestConfiguration.class})
public class QueryTest {

	@Autowired
	private ReserveApiController reserveApiController;
	
	@Before
	public void setUp() throws Exception {
        
    }
	
	@Test
	public void queryTest() throws Exception {
		System.out.println(reserveApiController.getCategory());
	}
}
