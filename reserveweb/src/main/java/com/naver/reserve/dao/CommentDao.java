package com.naver.reserve.dao;

import com.naver.reserve.dto.response.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getComment(int productId);
}
