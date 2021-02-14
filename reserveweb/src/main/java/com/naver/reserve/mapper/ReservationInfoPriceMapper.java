package com.naver.reserve.mapper;

import com.naver.reserve.dto.request.ReservationPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReservationInfoPriceMapper {
    void insertReservationInfoPrice(@Param("rId") int reservationInfoId, @Param("price") ReservationPrice price);
}
