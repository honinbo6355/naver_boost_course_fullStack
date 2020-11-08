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
public class ProductImage extends SystemDate {
    private String contentType;
    private boolean deleteFlag;
    private int fileInfoId;
    private String fileName;
    private int productId;
    private int productImageId;
    private String saveFileName;
    private String type;
}
