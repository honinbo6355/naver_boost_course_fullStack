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
    private DisplayInfo displayInfo;
    private List<ProductImage> productImages;
    private List<ProductPrice> prices;
    private String reservationDate;
}
