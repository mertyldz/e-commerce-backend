package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.DTO.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaxServiceImpl implements IBaseService<TaxEntity, TaxDTO, TaxRequestDTO> {
    private final TaxEntityRepository taxEntityRepository;
    private final TaxMapper taxMapper;

    @Override
    public List<TaxDTO> getAll() {
        return taxMapper.entityListToDTOList(taxEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        taxEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public TaxDTO getByUUID(UUID uuid) {
        TaxEntity taxEntity = taxEntityRepository.findByUuid(uuid).orElse(null);
        if (taxEntity != null) {
            return taxMapper.entityToDTO(taxEntity);
        } else {
            return null;
        }
    }

    @Override
    public TaxDTO create(TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = taxMapper.requestDTOToEntity(taxRequestDTO);
        taxEntityRepository.save(taxEntity);
        return taxMapper.entityToDTO(taxEntity);
    }

    @Override
    public TaxDTO updateByUUID(UUID uuid, TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = taxEntityRepository.findByUuid(uuid).orElse(null);
        if (taxEntity != null) {
            taxEntity = taxMapper.requestDTOToEntity(taxRequestDTO);
            taxEntityRepository.save(taxEntity);
            return taxMapper.entityToDTO(taxEntity);
        } else {
            return null;
        }
    }
}
