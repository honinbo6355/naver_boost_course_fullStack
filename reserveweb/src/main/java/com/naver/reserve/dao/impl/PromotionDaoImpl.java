package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.PromotionDao;
import com.naver.reserve.dao.mapper.PromotionMapper;
import com.naver.reserve.dto.response.Promotion;
import com.naver.reserve.dto.response.PromotionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromotionDaoImpl implements PromotionDao {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public List<Promotion> getPromotion() {
        return promotionMapper.selectPromotion();
    }
}
