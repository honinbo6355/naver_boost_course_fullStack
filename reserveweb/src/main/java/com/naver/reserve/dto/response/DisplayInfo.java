package com.naver.reserve.dto.response;

import com.naver.reserve.dto.common.SystemDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class DisplayInfo extends SystemDate {
    private int categoryId;
    private String categoryName;
    private int displayInfoId;
    private String email;
    private String homepage;
    private String openingHours;
    private String placeLot;
    private String placeName;
    private String placeStreet;
    private String productContent;
    private String productDescription;
    private String productEvent;
    private int productId;
    private String telephone;
}
