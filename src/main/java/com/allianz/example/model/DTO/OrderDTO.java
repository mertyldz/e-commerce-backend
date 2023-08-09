package com.allianz.example.model.DTO;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {
    private BigDecimal totalSellPrice;
    private OrderStatusEnum orderStatus;
    private CustomerDTO customer;
    private List<OrderItemDTO> orderItemList;

}
