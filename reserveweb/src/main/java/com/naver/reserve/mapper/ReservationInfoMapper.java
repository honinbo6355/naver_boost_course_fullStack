package com.naver.reserve.mapper;

import com.naver.reserve.dto.request.ReservationParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ReservationInfoMapper {
    int insertReservation(Map<String, Object> paramMap);
}
