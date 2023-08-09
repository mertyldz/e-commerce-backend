package com.allianz.example.model.requestDTO;

import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {

    private Integer quantity;

    private BigDecimal sellPrice;

    private ProductDTO product;
}
