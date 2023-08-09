package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.DTO.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SellerServiceImpl extends BaseServiceImpl<SellerEntity, SellerDTO, SellerRequestDTO, SellerEntityRepository, SellerMapper> implements SellerService<SellerEntity, SellerDTO, SellerRequestDTO> {
    public SellerServiceImpl(SellerEntityRepository repository, SellerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SellerDTO create(SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = mapper.requestDTOToEntity(sellerRequestDTO);
        repository.save(sellerEntity);
        return mapper.entityToDTO(sellerEntity);
    }

    @Override
    public SellerDTO updateByUUID(UUID uuid, SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = repository.findByUuid(uuid).orElse(null);
        if (sellerEntity != null) {
            sellerEntity = mapper.requestDTOToEntity(sellerRequestDTO);
            repository.save(sellerEntity);
            return mapper.entityToDTO(sellerEntity);
        } else {
            return null;
        }
    }
}
