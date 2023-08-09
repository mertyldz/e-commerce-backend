package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.DTO.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper implements IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {
        SellerDTO dto = new SellerDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setTc(entity.getTc());
        dto.setEmail(entity.getEmail());
        dto.setShopName(entity.getShopName());
        dto.setTaxOffice(entity.getTaxOffice());
        dto.setTaxNumber(entity.getTaxNumber());

        return dto;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setTc(dto.getTc());
        entity.setEmail(dto.getEmail());
        entity.setShopName(dto.getShopName());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setTaxNumber(dto.getTaxNumber());

        return entity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {
        List<SellerDTO> sellerDTOList = new ArrayList<>();
        for (SellerEntity sellerEntity : sellerEntities) {
            sellerDTOList.add(entityToDTO(sellerEntity));
        }
        return sellerDTOList;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {
        List<SellerEntity> sellerEntityList = new ArrayList<>();
        for (SellerDTO sellerDTO : sellerDTOS) {
            sellerEntityList.add(dtoToEntity(sellerDTO));
        }
        return sellerEntityList;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setTc(dto.getTc());
        entity.setEmail(dto.getEmail());
        entity.setShopName(dto.getShopName());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setTaxNumber(dto.getTaxNumber());

        return entity;
    }

    @Override
    public List<SellerEntity> requestDtoListToEntityList(List<SellerRequestDTO> sellerRequestDTOS) {
        return null;
    }
}
