package com.market.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ItemDTO {

    @NotBlank
    private String name;

    @Positive
    private Long quantity;
}
