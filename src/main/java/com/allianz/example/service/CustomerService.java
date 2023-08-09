package com.allianz.example.service;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerService<T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {
    Boolean addPersonToCustomer(UUID customerUUID, UUID personUUID);

    Boolean addOrderListToCustomer(UUID customerUUID, List<UUID> orderUUIDList);

    Boolean addOrderToCustomerOrderList(UUID customerUUID, UUID orderUUID);

}
