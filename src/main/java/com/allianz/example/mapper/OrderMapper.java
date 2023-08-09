package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.DTO.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {
    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    @Lazy
    OrderItemMapper orderItemMapper;

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getCreationDate());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setTotalSellPrice(entity.getTotalSellPrice());
        dto.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        dto.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));
        return dto;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getCreationDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
            orderDTOList.add(entityToDTO(orderEntity));
        }
        return orderDTOList;

    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (OrderDTO orderDTO : orderDTOS) {
            orderEntityList.add(dtoToEntity(orderDTO));
        }
        return orderEntityList;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getCreationDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        return entity;
    }

    @Override
    public List<OrderEntity> requestDtoListToEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        return null;
    }
}
