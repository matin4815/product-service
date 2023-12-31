package com.matin.productservice.dto.product;

import com.matin.productservice.dto.comment.CommentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends BaseProductDto{

    private Boolean isVisible = true;

    private Boolean canComment = true;

    private Boolean canVote = true;

    private List<CommentDto> comments;

    private Integer votesCount;

    private Double averageVote;
}
