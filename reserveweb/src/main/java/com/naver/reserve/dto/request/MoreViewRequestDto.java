package com.naver.reserve.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class MoreViewRequestDto {
    private int start;
    private int defaultViewCount = 4;

    public MoreViewRequestDto(int start) {
        this.start = start;
    }

    public int getStartViewCount() {
        return start * defaultViewCount;
    }

    public int getEndViewCount() {
        return defaultViewCount;
    }
}
