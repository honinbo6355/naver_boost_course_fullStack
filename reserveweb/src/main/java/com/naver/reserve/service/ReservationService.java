package com.naver.reserve.service;

import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.response.ReservationResponse;

public interface ReservationService {
    void createReservation(ReservationParam reservationParam) throws Exception;

    ReservationResponse getReservePageInfo(int displayInfoId) throws Exception;
}
