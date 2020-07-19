package com.naver.reserve.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Header {

    private String resultCode;

    private Object data;

    public void OK() {
        this.resultCode = "OK";
    }

    public void ERROR() {
        this.resultCode = "ERROR";
    }
}
