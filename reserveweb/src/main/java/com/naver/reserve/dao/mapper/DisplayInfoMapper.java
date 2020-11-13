package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.DisplayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DisplayInfoMapper {
    DisplayInfo selectDisplayInfo(@Param("displayInfoId") int displayInfoId);
}
