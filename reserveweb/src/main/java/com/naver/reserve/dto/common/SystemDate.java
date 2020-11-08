package com.naver.reserve.dto.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class SystemDate {
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
