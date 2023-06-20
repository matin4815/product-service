package com.matin.productservice.dto.referencedata;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReferenceTransferDataDto {

    private Long id;
    @NotBlank
    private String name;
}
