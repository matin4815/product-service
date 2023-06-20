package com.matin.productservice.dto.vote;

import com.matin.productservice.enums.VoteState;
import lombok.Data;

@Data
public class VoteDto extends BaseVoteDto {

    private VoteState state;

}
