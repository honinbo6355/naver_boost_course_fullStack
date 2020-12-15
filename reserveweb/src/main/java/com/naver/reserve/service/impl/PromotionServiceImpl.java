package com.naver.reserve.service.impl;

import com.naver.reserve.mapper.PromotionMapper;
import com.naver.reserve.dto.response.PromotionResponseDto;
import com.naver.reserve.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public PromotionResponseDto getPromotion() {
        PromotionResponseDto promotionResponseDto = new PromotionResponseDto();
        try {
            promotionResponseDto.setItems(promotionMapper.selectPromotion());
            System.out.println("promotionResponseDto : " + promotionResponseDto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotionResponseDto;
    }
}
