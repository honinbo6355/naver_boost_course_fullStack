package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.DisplayInfoImageDao;
import com.naver.reserve.dao.mapper.DisplayInfoImageMapper;
import com.naver.reserve.dto.response.DisplayInfoImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoImageDaoImpl implements DisplayInfoImageDao {

    @Autowired
    private DisplayInfoImageMapper displayInfoImageMapper;

    @Override
    public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
        return displayInfoImageMapper.selectDisplayInfoImage(displayInfoId);
    }
}
