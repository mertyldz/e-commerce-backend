package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.DTO.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements IBaseService<SellerEntity, SellerDTO, SellerRequestDTO> {
    private final SellerMapper sellerMapper;
    private final SellerEntityRepository sellerEntityRepository;

    @Override
    public List<SellerDTO> getAll() {
        return sellerMapper.entityListToDTOList(sellerEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        sellerEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public SellerDTO getByUUID(UUID uuid) {
        SellerEntity sellerEntity = sellerEntityRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity != null) {
            return sellerMapper.entityToDTO(sellerEntity);
        } else {
            return null;
        }
    }

    @Override
    public SellerDTO create(SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = sellerMapper.requestDTOToEntity(sellerRequestDTO);
        sellerEntityRepository.save(sellerEntity);
        return sellerMapper.entityToDTO(sellerEntity);
    }

    @Override
    public SellerDTO updateByUUID(UUID uuid, SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = sellerEntityRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity != null) {
            sellerEntity = sellerMapper.requestDTOToEntity(sellerRequestDTO);
            sellerEntityRepository.save(sellerEntity);
            return sellerMapper.entityToDTO(sellerEntity);
        } else {
            return null;
        }
    }
}
