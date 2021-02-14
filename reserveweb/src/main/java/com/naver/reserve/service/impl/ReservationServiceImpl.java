package com.naver.reserve.service.impl;

import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.request.ReservationPrice;
import com.naver.reserve.mapper.ReservationInfoMapper;
import com.naver.reserve.mapper.ReservationInfoPriceMapper;
import com.naver.reserve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationInfoMapper reservationInfoMapper;

    @Autowired
    private ReservationInfoPriceMapper reservationInfoPriceMapper;

    @Override
    public void createReservation(ReservationParam reservationParam) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("reservationParam", reservationParam);

        reservationInfoMapper.insertReservation(paramMap);

        int reservationInfoId = (int)paramMap.get("reservationInfoId");
        List<ReservationPrice> prices = reservationParam.getPrices();

        for (ReservationPrice price : prices) {
            reservationInfoPriceMapper.insertReservationInfoPrice(reservationInfoId, price);
        }
    }
}
