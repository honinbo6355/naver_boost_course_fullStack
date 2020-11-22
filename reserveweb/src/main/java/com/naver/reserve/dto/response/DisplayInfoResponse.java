package com.naver.reserve.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class DisplayInfoResponse {
    private double averageScore;
    private List<Comment> comments;
    private DisplayInfo displayInfo;
    private DisplayInfoImage displayInfoImage;
    private List<ProductImage> productImages;
    private List<ProductPrice> productPrices;
}
