package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {

    private Integer quantity;

    private BigDecimal sellPrice;
}
