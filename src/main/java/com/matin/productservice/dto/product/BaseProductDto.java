package com.matin.productservice.dto.product;

import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseProductDto {

    private Long id;

    @NotBlank(message = "product name can not be null!")
    private String name;

    private String description;

    @NotNull
    private ReferenceTransferDataDto provider;

    @NotNull
    private ReferenceTransferDataDto type;


}