package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.DTO.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {
    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setQuantity(entity.getQuantity());
        orderItemDTO.setSellPrice(entity.getSellPrice());
        orderItemDTO.setId(entity.getId());
        orderItemDTO.setUuid(entity.getUuid());
        orderItemDTO.setUpdatedDate(entity.getUpdatedDate());
        orderItemDTO.setCreationDate(entity.getCreationDate());

        return orderItemDTO;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setSellPrice(dto.getSellPrice());
        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setCreationDate(dto.getCreationDate());

        return orderItemEntity;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            orderItemDTOList.add(entityToDTO(orderItemEntity));
        }
        return orderItemDTOList;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            orderItemEntityList.add(dtoToEntity(orderItemDTO));
        }
        return orderItemEntityList;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setSellPrice(dto.getSellPrice());
        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setCreationDate(dto.getCreationDate());

        return orderItemEntity;
    }
}
