package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.DisplayInfoDao;
import com.naver.reserve.dao.mapper.DisplayInfoMapper;
import com.naver.reserve.dto.response.DisplayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoDaoImpl implements DisplayInfoDao {

    @Autowired
    private DisplayInfoMapper displayInfoMapper;

    @Override
    public DisplayInfo getDisplayInfo(int displayInfoId) {
        return displayInfoMapper.selectDisplayInfo(displayInfoId);
    }
}
