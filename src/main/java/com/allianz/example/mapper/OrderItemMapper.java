package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.DTO.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {
    @Autowired
    ProductMapper productMapper;

    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {
        OrderItemDTO dto = new OrderItemDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCreationDate(entity.getCreationDate());
        dto.setProduct(productMapper.entityToDTO(entity.getProduct()));
        dto.setQuantity(entity.getQuantity());
        dto.setSellPrice(entity.getSellPrice());

        return dto;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();

        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));

        return entity;
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
        OrderItemEntity entity = new OrderItemEntity();

        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));

        return entity;
    }

    @Override
    public List<OrderItemEntity> requestDtoListToEntityList(List<OrderItemRequestDTO> orderItemRequestDTOS) {
        List<OrderItemEntity> entityList = new ArrayList<>();
        for (OrderItemRequestDTO dto : orderItemRequestDTOS) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }
}
