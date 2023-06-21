package com.matin.productservice.dto.vote;

import com.matin.productservice.enums.VoteState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteStatusDto {

    @NotNull
    private Long id;

    @NotBlank
    private VoteState commentState;

}
