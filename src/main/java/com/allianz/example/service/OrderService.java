package com.allianz.example.service;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface OrderService <T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {

    Boolean addOrderItemListToOrder(UUID orderUUID, List<UUID> orderItemUUIDList);

    Boolean addOrderItemToOrder(UUID orderUUID, UUID orderItemUUID);

}
