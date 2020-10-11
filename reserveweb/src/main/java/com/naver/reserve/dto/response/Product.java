package com.naver.reserve.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String description;
    private String content;
    private int displayInfoId;
    private String placeName;
    private String imageUrl;
}
