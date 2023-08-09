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
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO, OrderItemEntityRepository, OrderItemMapper> implements OrderItemService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO> {

    private final ProductEntityRepository productEntityRepository;

    public OrderItemServiceImpl(OrderItemEntityRepository repository, OrderItemMapper mapper, ProductEntityRepository productEntityRepository) {
        super(repository, mapper);
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public OrderItemDTO create(OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItemEntity = mapper.requestDTOToEntity(orderItemRequestDTO);
        repository.save(orderItemEntity);
        return mapper.entityToDTO(orderItemEntity);
    }

    @Override
    public OrderItemDTO updateByUUID(UUID uuid, OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItemEntity = repository.findByUuid(uuid).orElse(null);
        if (orderItemEntity != null) {
            orderItemEntity = mapper.requestDTOToEntity(orderItemRequestDTO);
            repository.save(orderItemEntity);
            return mapper.entityToDTO(orderItemEntity);
        } else {
            return null;
        }
    }

    @Override
    public Boolean addProductToOrderItem(UUID orderItemUUID, UUID productUUID) {
        OrderItemEntity orderItemEntity = repository.findByUuid(orderItemUUID).orElse(null);
        ProductEntity productEntity = productEntityRepository.findByUuid(productUUID).orElse(null);
        if (orderItemEntity != null && productEntity != null) {
            orderItemEntity.setProduct(productEntity);
            repository.save(orderItemEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
