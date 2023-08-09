package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.DTO.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService<OrderEntity, OrderDTO, OrderRequestDTO> {
    private final OrderEntityRepository orderEntityRepository;
    private final OrderItemEntityRepository orderItemEntityRepository;
    private final OrderMapper orderMapper;


    @Override
    public Boolean addOrderItemListToOrder(UUID orderUUID, List<UUID> orderItemUUIDList) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).orElse(null);

        if (orderEntity != null) {

            if (orderEntity.getOrderItemList() != null) {
                for (UUID orderItemUUID : orderItemUUIDList) {
                    if (orderItemEntityRepository.findByUuid(orderItemUUID).isPresent()) {
                        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(orderItemUUID).get();
                        orderEntity.getOrderItemList().add(orderItemEntity);
                    }
                }
            } else {
                List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
                for (UUID orderItemUUID : orderItemUUIDList) {
                    if (orderItemEntityRepository.findByUuid(orderItemUUID).isPresent()) {
                        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(orderItemUUID).get();
                        orderItemEntityList.add(orderItemEntity);
                    }
                }
                orderEntity.setOrderItemList(orderItemEntityList);
            }
            orderEntityRepository.save(orderEntity);
            return Boolean.TRUE;

        } else {
            return Boolean.FALSE;
        }

    }

    @Override
    public Boolean addOrderItemToOrder(UUID orderUUID, UUID orderItemUUID) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).orElse(null);
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(orderItemUUID).orElse(null);
        if (orderEntity != null && orderItemEntity != null) {
            if (orderEntity.getOrderItemList() != null) {
                orderEntity.getOrderItemList().add(orderItemEntity);
            } else {
                List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
                orderItemEntityList.add(orderItemEntity);
                orderEntity.setOrderItemList(orderItemEntityList);

            }
            orderEntityRepository.save(orderEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderMapper.entityListToDTOList(orderEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        orderEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public OrderDTO getByUUID(UUID uuid) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity != null) {
            return orderMapper.entityToDTO(orderEntity);
        } else {
            return null;
        }
    }

    @Override
    public OrderDTO create(OrderRequestDTO orderRequestDTO) {
        OrderEntity orderEntity = orderMapper.requestDTOToEntity(orderRequestDTO);
        orderEntityRepository.save(orderEntity);
        return orderMapper.entityToDTO(orderEntity);
    }

    @Override
    public OrderDTO updateByUUID(UUID uuid, OrderRequestDTO orderRequestDTO) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if(orderEntity != null){
            orderEntity = orderMapper.requestDTOToEntity(orderRequestDTO);
            orderEntityRepository.save(orderEntity);
            return orderMapper.entityToDTO(orderEntity);
        } else {
            return null;
        }

    }
}
