package com.naver.reserve.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReservationParam {
    private int displayInfoId;
    private List<ReservationPrice> prices;
    private int productId;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private String reservationYearMonthDay;
}
