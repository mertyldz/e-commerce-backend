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
        SellerDTO sellerDTO = new SellerDTO();

        sellerDTO.setId(entity.getId());
        sellerDTO.setUuid(entity.getUuid());
        sellerDTO.setCreationDate(entity.getCreationDate());
        sellerDTO.setUpdatedDate(entity.getUpdatedDate());
        sellerDTO.setName(entity.getName());
        sellerDTO.setSurname(entity.getSurname());
        sellerDTO.setTc(entity.getTc());
        sellerDTO.setEmail(entity.getEmail());
        sellerDTO.setShopName(entity.getShopName());
        sellerDTO.setTaxOffice(entity.getTaxOffice());
        sellerDTO.setTaxNumber(entity.getTaxNumber());

        return sellerDTO;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setId(dto.getId());
        sellerEntity.setUuid(dto.getUuid());
        sellerEntity.setCreationDate(dto.getCreationDate());
        sellerEntity.setUpdatedDate(dto.getUpdatedDate());
        sellerEntity.setName(dto.getName());
        sellerEntity.setSurname(dto.getSurname());
        sellerEntity.setTc(dto.getTc());
        sellerEntity.setEmail(dto.getEmail());
        sellerEntity.setShopName(dto.getShopName());
        sellerEntity.setTaxOffice(dto.getTaxOffice());
        sellerEntity.setTaxNumber(dto.getTaxNumber());

        return sellerEntity;
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
        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setId(dto.getId());
        sellerEntity.setUuid(dto.getUuid());
        sellerEntity.setCreationDate(dto.getCreationDate());
        sellerEntity.setUpdatedDate(dto.getUpdatedDate());
        sellerEntity.setName(dto.getName());
        sellerEntity.setSurname(dto.getSurname());
        sellerEntity.setTc(dto.getTc());
        sellerEntity.setEmail(dto.getEmail());
        sellerEntity.setShopName(dto.getShopName());
        sellerEntity.setTaxOffice(dto.getTaxOffice());
        sellerEntity.setTaxNumber(dto.getTaxNumber());

        return sellerEntity;
    }
}
