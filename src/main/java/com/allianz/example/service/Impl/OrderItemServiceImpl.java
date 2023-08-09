package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.DTO.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO> {

    private final OrderItemEntityRepository orderItemEntityRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductEntityRepository productEntityRepository;


    @Override
    public Boolean addProductToOrderItem(UUID orderItemUUID, UUID productUUID) {
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(orderItemUUID).orElse(null);
        ProductEntity productEntity = productEntityRepository.findByUuid(productUUID).orElse(null);
        if (orderItemEntity != null && productEntity != null) {
            orderItemEntity.setProduct(productEntity);
            orderItemEntityRepository.save(orderItemEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<OrderItemDTO> getAll() {
        return orderItemMapper.entityListToDTOList(orderItemEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        orderItemEntityRepository.deleteByUuid(uuid);

    }

    @Override
    public OrderItemDTO getByUUID(UUID uuid) {
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity != null) {
            return orderItemMapper.entityToDTO(orderItemEntity);
        } else {
            return null;
        }
    }

    @Override
    public OrderItemDTO create(OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItemEntity = orderItemMapper.requestDTOToEntity(orderItemRequestDTO);
        orderItemEntityRepository.save(orderItemEntity);
        return orderItemMapper.entityToDTO(orderItemEntity);
    }

    @Override
    public OrderItemDTO updateByUUID(UUID uuid, OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity != null) {
            orderItemEntity = orderItemMapper.requestDTOToEntity(orderItemRequestDTO);
            orderItemEntityRepository.save(orderItemEntity);
            return orderItemMapper.entityToDTO(orderItemEntity);
        } else {
            return null;
        }

    }
}
