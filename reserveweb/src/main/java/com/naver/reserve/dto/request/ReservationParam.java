package com.naver.reserve.dto.request;

import java.util.List;

public class ReservationParam {
    private int displayInfoId;
    private List<ReservationPrice> prices;
    private int productId;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private String reservationYearMonthDay;
}
