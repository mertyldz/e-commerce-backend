package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProductServiceImpl implements IBaseService<ProductEntity, ProductDTO, ProductRequestDTO> {
    private final ProductEntityRepository productEntityRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        return productMapper.entityListToDTOList(productEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        productEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public ProductDTO getByUUID(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            return productMapper.entityToDTO(productEntity);
        } else {
            return null;
        }
    }

    @Override
    public ProductDTO create(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productMapper.requestDTOToEntity(productRequestDTO);
        productEntityRepository.save(productEntity);
        return productMapper.entityToDTO(productEntity);
    }

    @Override
    public ProductDTO updateByUUID(UUID uuid, ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            productEntity = productMapper.requestDTOToEntity(productRequestDTO);
            productEntityRepository.save(productEntity);
            return productMapper.entityToDTO(productEntity);
        } else {
            return null;
        }
    }

}
