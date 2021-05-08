package com.naver.reserve.service.impl;

import com.naver.reserve.dto.request.ReservationParam;
import com.naver.reserve.dto.request.ReservationPrice;
import com.naver.reserve.dto.response.DisplayInfo;
import com.naver.reserve.dto.response.ProductImage;
import com.naver.reserve.dto.response.ProductPrice;
import com.naver.reserve.dto.response.ReservationResponse;
import com.naver.reserve.mapper.*;
import com.naver.reserve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationInfoMapper reservationInfoMapper;

    @Autowired
    private ReservationInfoPriceMapper reservationInfoPriceMapper;

    @Autowired
    private DisplayInfoMapper displayInfoMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createReservation(ReservationParam reservationParam) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("reservationParam", reservationParam);

        reservationInfoMapper.insertReservation(paramMap);

        int reservationInfoId = (int)paramMap.get("reservationInfoId");
        List<ReservationPrice> prices = reservationParam.getPrices();

        for (ReservationPrice price : prices) {
            reservationInfoPriceMapper.insertReservationInfoPrice(reservationInfoId, price);
        }
    }

    @Override
    public ReservationResponse getReservePageInfo(int displayInfoId) throws Exception {
        ReservationResponse reservationResponse = new ReservationResponse();

        DisplayInfo displayInfo = displayInfoMapper.selectDisplayInfo(displayInfoId);
        int productId = displayInfo.getProductId();
        List<ProductImage> productImages = productImageMapper.selectProductImages(productId);
        List<ProductPrice> prices = productPriceMapper.selectProductPrice(productId);

        Random random = new Random();
        int randDay = random.nextInt(5) + 1;

        String reservationDate = LocalDate.now().plusDays(randDay).toString();

        reservationResponse.setDisplayInfo(displayInfo);
        reservationResponse.setProductImages(productImages);
        reservationResponse.setPrices(prices);
        reservationResponse.setReservationDate(reservationDate);

        return reservationResponse;
    }
}
