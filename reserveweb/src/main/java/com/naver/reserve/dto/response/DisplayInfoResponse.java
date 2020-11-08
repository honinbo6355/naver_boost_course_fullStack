package com.naver.reserve.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class DisplayInfoResponse {
    private double averageScore;
    private Comment comments;
    private DisplayInfo displayInfo;
    private DisplayInfoImage displayInfoImage;
    private ProductImage productImages;
    private ProductPrice productPrices;
}
