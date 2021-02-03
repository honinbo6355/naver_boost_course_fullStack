package com.naver.reserve.mapper;

import com.naver.reserve.dto.request.ReservationParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationInfoMapper {
    int insertReservation(ReservationParam reservationParam);
}
