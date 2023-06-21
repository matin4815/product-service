package com.matin.productservice.dto.comment;

import com.matin.productservice.enums.CommentState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentStatusDto {

    @NotNull
    private Long id;

    @NotBlank
    private CommentState commentState;

}
