package com.naver.reserve.service;

import com.naver.reserve.dto.request.ReservationParam;

public interface ReservationService {
    int createReservation(ReservationParam reservationParam) throws Exception;
}