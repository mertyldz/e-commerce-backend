package com.allianz.example.mapper;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.DTO.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMapper implements IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {
        TaxDTO taxDTO = new TaxDTO();

        taxDTO.setId(entity.getId());
        taxDTO.setUuid(entity.getUuid());
        taxDTO.setCreationDate(entity.getCreationDate());
        taxDTO.setUpdatedDate(entity.getUpdatedDate());
        taxDTO.setRate(entity.getRate());
        taxDTO.setName(entity.getName());
        taxDTO.setCode(entity.getCode());

        return taxDTO;
    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {
        TaxEntity taxEntity = new TaxEntity();

        taxEntity.setId(dto.getId());
        taxEntity.setUuid(dto.getUuid());
        taxEntity.setCreationDate(dto.getCreationDate());
        taxEntity.setUpdatedDate(dto.getUpdatedDate());
        taxEntity.setRate(dto.getRate());
        taxEntity.setName(dto.getName());
        taxEntity.setCode(dto.getCode());

        return taxEntity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {
        List<TaxDTO> taxDTOList = new ArrayList<>();
        for (TaxEntity taxEntity : taxEntities) {
            taxDTOList.add(entityToDTO(taxEntity));
        }
        return taxDTOList;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> taxDTOS) {
        List<TaxEntity> taxEntityList = new ArrayList<>();
        for (TaxDTO taxDTO : taxDTOS) {
            taxEntityList.add(dtoToEntity(taxDTO));
        }
        return taxEntityList;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {
        TaxEntity taxEntity = new TaxEntity();

        taxEntity.setId(dto.getId());
        taxEntity.setUuid(dto.getUuid());
        taxEntity.setCreationDate(dto.getCreationDate());
        taxEntity.setUpdatedDate(dto.getUpdatedDate());
        taxEntity.setRate(dto.getRate());
        taxEntity.setName(dto.getName());
        taxEntity.setCode(dto.getCode());

        return taxEntity;
    }

    @Override
    public List<TaxEntity> requestDtoListToEntityList(List<TaxRequestDTO> taxRequestDTOS) {
        return null;
    }
}
