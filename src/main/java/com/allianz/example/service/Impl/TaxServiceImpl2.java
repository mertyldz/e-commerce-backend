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
public class TaxServiceImpl2 extends BaseServiceImpl<TaxEntity, TaxDTO, TaxRequestDTO, TaxEntityRepository, TaxMapper> implements IBaseService<TaxEntity, TaxDTO, TaxRequestDTO> {

    public TaxServiceImpl2(TaxEntityRepository repository, TaxMapper mapper) {
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
