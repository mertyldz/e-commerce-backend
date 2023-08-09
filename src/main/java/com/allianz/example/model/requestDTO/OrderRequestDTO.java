package com.allianz.example.model.requestDTO;

import com.allianz.example.model.DTO.CustomerDTO;
import com.allianz.example.model.DTO.OrderItemDTO;
import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO extends BaseDTO {
    private BigDecimal totalSellPrice;
    private OrderStatusEnum orderStatus;
    private List<OrderItemDTO> orderItemList;
    private CustomerDTO customer;

}
