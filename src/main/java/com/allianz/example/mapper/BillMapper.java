package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.DTO.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    @Lazy
    OrderMapper orderMapper;

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());

        dto.setBillDate(entity.getBillDate());
        dto.setBillNo(entity.getBillNo());
        dto.setTaxRate(entity.getTaxRate());
        dto.setTaxAmount(entity.getTaxAmount());
        dto.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        dto.setTotalSellPrice(entity.getTotalSellPrice());
        dto.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        return dto;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity billEntity = new BillEntity();

        billEntity.setCreationDate(dto.getCreationDate());
        billEntity.setUpdatedDate(dto.getUpdatedDate());
        billEntity.setId(dto.getId());
        billEntity.setUuid(dto.getUuid());

        billEntity.setBillDate(dto.getBillDate());
        billEntity.setBillNo(dto.getBillNo());
        billEntity.setTaxAmount(dto.getTaxAmount());
        billEntity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(dto.getTotalSellPrice());
        billEntity.setTaxRate(dto.getTaxRate());
        billEntity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return billEntity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> billDTOs = new ArrayList<>();
        for (BillEntity billEntity : billEntities) {
            billDTOs.add(entityToDTO(billEntity));
        }
        return billDTOs;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> billEntityList = new ArrayList<>();
        for (BillDTO billDTO : billDTOS) {
            billEntityList.add(dtoToEntity(billDTO));
        }
        return billEntityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity billEntity = new BillEntity();

        billEntity.setCreationDate(dto.getCreationDate());
        billEntity.setUpdatedDate(dto.getUpdatedDate());
        billEntity.setId(dto.getId());
        billEntity.setUuid(dto.getUuid());

        billEntity.setBillDate(dto.getBillDate());
        billEntity.setBillNo(dto.getBillNo());
        billEntity.setTaxAmount(dto.getTaxAmount());
        billEntity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(dto.getTotalSellPrice());
        billEntity.setTaxRate(dto.getTaxRate());
        billEntity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return billEntity;
    }

    @Override
    public List<BillEntity> requestDtoListToEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }
}
