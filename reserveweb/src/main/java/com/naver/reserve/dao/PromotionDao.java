package com.naver.reserve.dao;

import com.naver.reserve.dto.response.Promotion;
import com.naver.reserve.dto.response.PromotionResponseDto;

import java.util.List;

public interface PromotionDao {

    List<Promotion> getPromotion();
}
