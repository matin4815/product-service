package com.matin.productservice.mapper;

import com.matin.productservice.dal.entity.Comment;
import com.matin.productservice.dto.comment.CommentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    Comment toComment(CommentDto commentDto);

    CommentDto toCommentDto(Comment comment);

    List<Comment> listCommentDtoToComment(List<CommentDto> commentDto);

    List<CommentDto> listCommentToCommentDto(List<Comment> comment);
}
