package com.naver.reserve.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class ProductResponseDto {
    private int id;
    private String description;
    private String content;
    private int displayInfoId;
    private String placeName;
    private String imageUrl;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
