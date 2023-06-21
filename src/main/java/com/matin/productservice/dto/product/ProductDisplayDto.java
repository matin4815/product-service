package com.matin.productservice.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDisplayDto {

    private Long productId;

    @NotNull
    private Boolean enable;

}
