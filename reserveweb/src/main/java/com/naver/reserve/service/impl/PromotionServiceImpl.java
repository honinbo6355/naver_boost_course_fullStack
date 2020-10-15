package com.naver.reserve.service.impl;

import com.naver.reserve.dao.PromotionDao;
import com.naver.reserve.dao.impl.PromotionDaoImpl;
import com.naver.reserve.dto.response.PromotionResponseDto;
import com.naver.reserve.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionDao promotionDao;

    @Override
    public PromotionResponseDto getPromotion() {
        PromotionResponseDto promotionResponseDto = new PromotionResponseDto();
        try {
            promotionResponseDto.setItems(promotionDao.getPromotion());
            System.out.println("promotionResponseDto : " + promotionResponseDto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotionResponseDto;
    }
}
