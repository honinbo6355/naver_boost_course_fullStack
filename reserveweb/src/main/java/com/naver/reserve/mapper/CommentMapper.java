package com.naver.reserve.mapper;

import com.naver.reserve.dto.response.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> selectComment(@Param("productId") int productId);

    Double selectAverageScore(@Param("productId") int productId);
}
