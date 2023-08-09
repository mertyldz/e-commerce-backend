package com.allianz.example.util;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBaseService<T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO> {
    List<ResponseDTO> getAll();

    void deleteByUUID(UUID uuid);

    ResponseDTO getByUUID(UUID uuid);

    ResponseDTO create(RequestDTO requestDTO);

    ResponseDTO updateByUUID(UUID uuid, RequestDTO requestDTO);

}
