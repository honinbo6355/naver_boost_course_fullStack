package com.naver.reserve.service;

import com.naver.reserve.dto.response.DisplayInfoResponse;

public interface DisplayInfoService {
    DisplayInfoResponse getProductDetail(int displayInfoId);
}
