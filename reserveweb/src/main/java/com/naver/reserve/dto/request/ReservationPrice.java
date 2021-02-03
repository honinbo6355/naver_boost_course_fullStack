package com.naver.reserve.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationPrice {
    private int reservationInfoPriceId;
    private int reservationInfoId;
    private int productPriceId;
    private int count;
}
