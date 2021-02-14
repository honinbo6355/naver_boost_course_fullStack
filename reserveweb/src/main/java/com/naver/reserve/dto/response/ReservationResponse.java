package com.naver.reserve.dto.response;

import com.naver.reserve.dto.common.SystemDate;
import com.naver.reserve.dto.request.ReservationPrice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReservationResponse extends SystemDate {
    private boolean cancelYn;
    private String displayInfoId;
    private List<ReservationPrice> prices;
    private int productId;
    private String reservationDate;
    private String reservationEmail;
    private int reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
}
