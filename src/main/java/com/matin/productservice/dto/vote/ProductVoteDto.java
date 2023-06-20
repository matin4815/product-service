package com.matin.productservice.dto.vote;

import lombok.Data;

@Data
public class ProductVoteDto {

    private Long productId;

    private Integer votesCount;

    private Double averageVote;
}
