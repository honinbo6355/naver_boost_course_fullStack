package com.naver.reserve.service;

import com.naver.reserve.config.ApplicationConfig;
import com.naver.reserve.config.WebConfig;
import com.naver.reserve.controller.ReserveApiController;
import com.naver.reserve.dto.response.DisplayInfoResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, WebConfig.class})
@WebAppConfiguration
public class ProductServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private ReserveApiController reserveApiController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(reserveApiController).build();
    }

    @Test
    public void 상품_상세_조회() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/products/" + 1)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
