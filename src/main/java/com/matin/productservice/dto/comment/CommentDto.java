package com.matin.productservice.dto.comment;

import com.matin.productservice.enums.CommentState;
import lombok.Data;

@Data
public class CommentDto extends BaseCommentDto{

    private String state;

}
