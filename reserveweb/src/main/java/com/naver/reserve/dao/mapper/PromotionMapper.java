package com.naver.reserve.dao.mapper;

import com.naver.reserve.dto.response.Promotion;

import java.util.List;

public interface PromotionMapper {
    List<Promotion> selectPromotion();
}
