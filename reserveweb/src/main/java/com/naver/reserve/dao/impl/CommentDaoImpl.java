package com.naver.reserve.dao.impl;

import com.naver.reserve.dao.CommentDao;
import com.naver.reserve.dao.mapper.CommentMapper;
import com.naver.reserve.dto.response.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(int productId) {
        return commentMapper.selectComment(productId);
    }
}
