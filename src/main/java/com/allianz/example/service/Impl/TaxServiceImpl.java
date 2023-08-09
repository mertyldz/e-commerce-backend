package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.DTO.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.service.TaxService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaxServiceImpl extends BaseServiceImpl<TaxEntity, TaxDTO, TaxRequestDTO, TaxEntityRepository, TaxMapper> implements TaxService<TaxEntity, TaxDTO, TaxRequestDTO> {

    public TaxServiceImpl(TaxEntityRepository repository, TaxMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public TaxDTO create(TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = mapper.requestDTOToEntity(taxRequestDTO);
        repository.save(taxEntity);
        return mapper.entityToDTO(taxEntity);
    }

    @Override
    public TaxDTO updateByUUID(UUID uuid, TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = repository.findByUuid(uuid).orElse(null);
        if (taxEntity != null) {
            taxEntity = mapper.requestDTOToEntity(taxRequestDTO);
            repository.save(taxEntity);
            return mapper.entityToDTO(taxEntity);
        } else {
            return null;
        }
    }
}
