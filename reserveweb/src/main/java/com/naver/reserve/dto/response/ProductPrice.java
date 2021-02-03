package com.naver.reserve.dto.response;

import com.naver.reserve.dto.common.SystemDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductPrice extends SystemDate {
    private double discountRate;
    private int price;
    private String priceTypeName;
    private int productId;
    private int productPriceId;
}
