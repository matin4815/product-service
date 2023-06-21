package com.matin.productservice.dto.comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ChangeCommentStatusDto {

    @NotNull
    private Long productId;

    @NotEmpty
    private List<CommentStatusDto> newStatus;
}
