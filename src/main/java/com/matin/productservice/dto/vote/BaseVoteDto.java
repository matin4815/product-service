package com.matin.productservice.dto.vote;

import com.matin.productservice.dal.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BaseVoteDto {


    private Long id;

    @NotBlank
    private String content;

    @NotNull
    private Product product;

    @NotBlank
    private String username;

    @NotNull
    private Date entryDate;
}
