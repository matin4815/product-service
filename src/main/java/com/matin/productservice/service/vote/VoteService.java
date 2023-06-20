package com.matin.productservice.service.vote;

import com.matin.productservice.dto.vote.ProductVoteDto;
import com.matin.productservice.dto.vote.VoteDto;

public interface VoteService {

    Boolean voteOnProduct(Long productId, VoteDto voteDto);

    ProductVoteDto getProductVoteDetails(Long productId);
}
