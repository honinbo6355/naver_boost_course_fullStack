package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.DisplayInfoImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DisplayInfoImageMapper {
    DisplayInfoImage selectDisplayInfoImage(@Param("displayInfoId") int displayInfoId);
}
