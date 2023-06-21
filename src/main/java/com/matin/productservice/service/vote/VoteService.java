package com.matin.productservice.service.vote;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.vote.ChangeVoteStatusDto;
import com.matin.productservice.dto.vote.ProductVoteDto;
import com.matin.productservice.dto.vote.VoteDto;

public interface VoteService {

    Boolean voteOnProduct(Long productId, VoteDto voteDto);

    ProductVoteDto getProductVoteDetails(Long productId);

    Integer getVoteCountByProductAndState(Product product);

    Double getAverageVoteValueByProductAndState(Product product);

    Boolean changeVoteStatus(ChangeVoteStatusDto changeVoteStatusDto);
}
