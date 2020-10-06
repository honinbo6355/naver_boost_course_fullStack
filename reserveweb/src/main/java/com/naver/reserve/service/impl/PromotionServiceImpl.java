package com.naver.reserve.service.impl;

import com.naver.reserve.dao.PromotionDao;
import com.naver.reserve.dao.impl.PromotionDaoImpl;
import com.naver.reserve.dto.Header;
import com.naver.reserve.dto.request.MoreViewRequestDto;
import com.naver.reserve.dto.response.PromotionResponseDto;
import com.naver.reserve.service.ProductService;
import com.naver.reserve.service.PromotionService;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionDao promotionDao;

    public PromotionServiceImpl(PromotionDaoImpl promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    public Header getPromotion() {
        Header header = new Header();
        try {
            PromotionResponseDto promotionResponseDto = new PromotionResponseDto();
            promotionResponseDto.setItems(promotionDao.getPromotion());
            System.out.println("promotionResponseDto : " + promotionResponseDto);

            header.setData(promotionResponseDto);
            header.OK();
        } catch (Exception e) {
            e.printStackTrace();
            header.ERROR();
        }

        return header;
    }
}
