package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.DTO.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {
    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setCreationDate(entity.getCreationDate());
        billDTO.setUpdatedDate(entity.getUpdatedDate());
        billDTO.setId(entity.getId());
        billDTO.setUuid(entity.getUuid());

        billDTO.setBillDate(entity.getBillDate());
        billDTO.setBillNo(entity.getBillNo());
        billDTO.setTaxAmount(entity.getTaxAmount());
        billDTO.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        billDTO.setTotalSellPrice(entity.getTotalSellPrice());
        billDTO.setTaxRate(entity.getTaxRate());

        return billDTO;
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

        return billEntity;
    }
}
