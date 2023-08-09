package com.allianz.example.database.entity;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class OrderEntity extends BaseEntity {

    @Column
    private BigDecimal totalSellPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @ManyToOne
    private CustomerEntity customer;

    @OneToMany
    private List<OrderItemEntity> orderItemList;
}
