package com.allianz.example.model.DTO;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO extends BaseDTO {
    private BigDecimal totalSellPrice;
    private OrderStatusEnum orderStatus;

}
