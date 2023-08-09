package com.allianz.example.model.requestDTO;

import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO extends BaseDTO {

    private String name;

    private String code;

    private ColorEnum color;

    private BigDecimal sellPrice;

    private BigDecimal buyPrice;

    private Integer quantity;
}
