package com.matin.productservice.dto.vote;

import com.matin.productservice.dal.entity.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BaseVoteDto {

    private Long id;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer value;

    private Product product;

    @NotBlank
    private String username;

    @NotNull
    private Date entryDate;
}
