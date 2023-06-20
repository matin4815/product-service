package com.matin.productservice.dto.referencedata;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReferenceTransferDataDto {

    private Long id;
    @NotBlank
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
