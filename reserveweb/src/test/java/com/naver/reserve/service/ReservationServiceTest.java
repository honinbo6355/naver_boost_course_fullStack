package com.naver.reserve.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naver.reserve.config.ApplicationConfig;
import com.naver.reserve.config.WebConfig;
import com.naver.reserve.controller.ReserveApiController;
import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.request.ReservationPrice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
public class ReservationServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private ReserveApiController reserveApiController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(reserveApiController).build();
    }

    @Test
    public void 예약하기() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ReservationParam reservationParam = new ReservationParam();
        reservationParam.setProductId(3);
        reservationParam.setDisplayInfoId(3);
        reservationParam.setReservationName("테스트");
        reservationParam.setReservationTelephone("010-1234-5678");
        reservationParam.setReservationEmail("test@naver.com");
        reservationParam.setReservationYearMonthDay("2020-12-12");

        List<ReservationPrice> prices = new ArrayList<>();

        ReservationPrice price1 = new ReservationPrice();
        price1.setReservationInfoId(3);
        price1.setProductPriceId(1);
        price1.setCount(3);

        ReservationPrice price2 = new ReservationPrice();
        price2.setReservationInfoId(4);
        price2.setProductPriceId(2);
        price2.setCount(5);

        prices.add(price1);
        prices.add(price2);

        reservationParam.setPrices(prices);

        String body = objectMapper.writeValueAsString(reservationParam);

        MvcResult mvcResult = mockMvc.perform(post("/api/reserve")
                                .content(body)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult.getResponse().getStatus());
    }
}
