package com.matin.productservice.dto.vote;

import com.matin.productservice.dto.comment.CommentStatusDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ChangeVoteStatusDto {

    @NotNull
    private Long productId;

    @NotEmpty
    private List<VoteStatusDto> newStatus;
}
