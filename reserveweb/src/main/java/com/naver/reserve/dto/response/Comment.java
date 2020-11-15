package com.naver.reserve.dto.response;

import com.naver.reserve.dto.common.SystemDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class Comment extends SystemDate {
    private String comment;
    private int commendId;
    private CommentImage commentImages;
    private int productId;
    private LocalDateTime reservationDate;
    private String reservationEmail;
    private int reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private double score;
}