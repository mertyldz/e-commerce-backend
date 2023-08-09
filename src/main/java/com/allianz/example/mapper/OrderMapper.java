package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.DTO.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {
    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(entity.getId());
        orderDTO.setUuid(entity.getUuid());
        orderDTO.setCreationDate(entity.getCreationDate());
        orderDTO.setUpdatedDate(entity.getCreationDate());
        orderDTO.setOrderStatus(entity.getOrderStatus());
        orderDTO.setTotalSellPrice(entity.getTotalSellPrice());
        return orderDTO;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setUuid(dto.getUuid());
        orderEntity.setCreationDate(dto.getCreationDate());
        orderEntity.setUpdatedDate(dto.getCreationDate());
        orderEntity.setOrderStatus(dto.getOrderStatus());
        orderEntity.setTotalSellPrice(dto.getTotalSellPrice());
        return orderEntity;
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
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setUuid(dto.getUuid());
        orderEntity.setCreationDate(dto.getCreationDate());
        orderEntity.setUpdatedDate(dto.getCreationDate());
        orderEntity.setOrderStatus(dto.getOrderStatus());
        orderEntity.setTotalSellPrice(dto.getTotalSellPrice());
        return orderEntity;
    }
}
