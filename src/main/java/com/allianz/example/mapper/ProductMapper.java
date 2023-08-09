package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.DTO.CategoryDTO;
import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {
    @Autowired
    TaxMapper taxMapper;
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setColor(entity.getColor());
        dto.setQuantity(entity.getQuantity());
        dto.setSellPrice(entity.getSellPrice());
        dto.setBuyPrice(entity.getBuyPrice());
        dto.setTax(taxMapper.entityToDTO(entity.getTax()));
        Set<CategoryDTO> categoryEntitySet =
                new HashSet<>(categoryMapper.entityListToDTOList(new ArrayList<>(entity.getCategoryList())));

        dto.setCategoryList(categoryEntitySet);

        return dto;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setTax(taxMapper.dtoToEntity(dto.getTax()));

        Set<CategoryEntity> categoryEntities =
                new HashSet<>(categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList())));
        entity.setCategoryList(categoryEntities);

        return entity;
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
        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setTax(taxMapper.dtoToEntity(dto.getTax()));

        Set<CategoryEntity> categoryEntities =
                new HashSet<>(categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList())));
        entity.setCategoryList(categoryEntities);

        return entity;

    }

    @Override
    public List<ProductEntity> requestDtoListToEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }
}
