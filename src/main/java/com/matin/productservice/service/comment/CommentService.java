package com.matin.productservice.service.comment;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.comment.CommentDto;

import java.util.List;

public interface CommentService {

    Boolean addCommentToProduct(Long productId, CommentDto commentDto);

    List<CommentDto> getProductComments(Long productId, Integer page);

    List<CommentDto> getProductCommentsForMainPage(Product product, Integer page, Integer size);
}
