package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {
    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(entity.getId());
        productDTO.setUuid(entity.getUuid());
        productDTO.setCreationDate(entity.getCreationDate());
        productDTO.setUpdatedDate(entity.getUpdatedDate());
        productDTO.setName(entity.getName());
        productDTO.setCode(entity.getCode());
        productDTO.setColor(entity.getColor());
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setSellPrice(entity.getSellPrice());
        productDTO.setBuyPrice(entity.getBuyPrice());

        return productDTO;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(dto.getId());
        productEntity.setUuid(dto.getUuid());
        productEntity.setCreationDate(dto.getCreationDate());
        productEntity.setUpdatedDate(dto.getUpdatedDate());
        productEntity.setName(dto.getName());
        productEntity.setCode(dto.getCode());
        productEntity.setColor(dto.getColor());
        productEntity.setQuantity(dto.getQuantity());
        productEntity.setSellPrice(dto.getSellPrice());
        productEntity.setBuyPrice(dto.getBuyPrice());

        return productEntity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            productDTOList.add(entityToDTO(productEntity));
        }
        return productDTOList;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> productEntityList = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            productEntityList.add(dtoToEntity(productDTO));
        }
        return productEntityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(dto.getId());
        productEntity.setUuid(dto.getUuid());
        productEntity.setCreationDate(dto.getCreationDate());
        productEntity.setUpdatedDate(dto.getUpdatedDate());
        productEntity.setName(dto.getName());
        productEntity.setCode(dto.getCode());
        productEntity.setColor(dto.getColor());
        productEntity.setQuantity(dto.getQuantity());
        productEntity.setSellPrice(dto.getSellPrice());
        productEntity.setBuyPrice(dto.getBuyPrice());

        return productEntity;
    }
}
