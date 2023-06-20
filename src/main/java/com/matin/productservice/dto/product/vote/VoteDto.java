package com.matin.productservice.dto.product.vote;

import com.matin.productservice.enums.VoteState;
import lombok.Data;

@Data
public class VoteDto {

    private VoteState state;

}
