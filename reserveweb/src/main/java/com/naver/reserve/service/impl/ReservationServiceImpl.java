package com.naver.reserve.service.impl;

import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.mapper.ReservationInfoMapper;
import com.naver.reserve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationInfoMapper reservationInfoMapper;

    @Override
    public int createReservation(ReservationParam reservationParam) throws Exception {
        return reservationInfoMapper.insertReservation(reservationParam);
    }
}
