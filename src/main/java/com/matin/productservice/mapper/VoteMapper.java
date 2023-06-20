package com.matin.productservice.mapper;

import com.matin.productservice.dal.entity.Vote;
import com.matin.productservice.dto.product.vote.VoteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface VoteMapper {

    Vote toVote(VoteDto voteDto);

    VoteDto toVoteDto(Vote vote);

    List<Vote> listVoteDtoToVote(List<VoteDto> voteDtos);

    List<VoteDto> listVoteToVoteDto(List<Vote> votes);
}
