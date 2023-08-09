package com.allianz.example.service;

import com.allianz.example.util.IBaseService;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.UUID;

public interface BillService<T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {

    Boolean addOrderToBill(UUID orderUUID, UUID billUUID);

}
