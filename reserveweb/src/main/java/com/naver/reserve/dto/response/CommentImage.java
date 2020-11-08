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
public class CommentImage extends SystemDate {
    private String contentType;
    private boolean deleteFlag;
    private int fileId;
    private String fileName;
    private int imageId;
    private int reservationInfoId;
    private int reservationUserCommentId;
    private String saveFileName;
}
