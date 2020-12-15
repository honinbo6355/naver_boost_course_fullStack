package com.naver.reserve.mapper;

import com.naver.reserve.dto.response.Promotion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {
    List<Promotion> selectPromotion();
}
