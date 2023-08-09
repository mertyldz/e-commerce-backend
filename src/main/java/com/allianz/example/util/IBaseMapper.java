package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;

public interface IBaseMapper<ResponseDTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    ResponseDTO entityToDTO(Entity entity);

    Entity dtoToEntity(ResponseDTO dto);

    List<ResponseDTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<ResponseDTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);
    List<Entity> requestDtoListToEntityList(List<RequestDTO> requestDTOList);


}
