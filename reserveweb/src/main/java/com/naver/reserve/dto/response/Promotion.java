package com.naver.reserve.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Promotion {
    private int id;
    private int productId;
    private String productImageUrl;
}
