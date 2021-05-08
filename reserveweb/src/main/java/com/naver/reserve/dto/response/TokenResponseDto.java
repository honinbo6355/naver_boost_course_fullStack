package com.naver.reserve.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
public class TokenResponseDto {
    private String token;
}
