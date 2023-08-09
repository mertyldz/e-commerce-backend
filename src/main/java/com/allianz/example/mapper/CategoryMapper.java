package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.DTO.CategoryDTO;
import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryCreateRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryCreateRequestDTO> {
    @Autowired
    @Lazy
    ProductMapper productMapper;

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(entity.getName());

        Set<ProductDTO> productDTOS = new HashSet<>(new ArrayList<>(productMapper.entityListToDTOList(new ArrayList<>(entity.getProductList()))));
        dto.setProductList(productDTOS);

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());

        Set<ProductEntity> productEntities = new HashSet<>(new ArrayList<>(productMapper.dtoListTOEntityList(new ArrayList<>(dto.getProductList()))));
        categoryEntity.setProductList(productEntities);
        return categoryEntity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {
        List<CategoryDTO> DTOList = new ArrayList<>();

        for (CategoryEntity entity : categoryEntities) {
            CategoryDTO categoryDTO = entityToDTO(entity);
            DTOList.add(categoryDTO);
        }

        return DTOList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {

        List<CategoryEntity> entities = new ArrayList<>();

        for (CategoryDTO dto : categoryDTOS) {
            CategoryEntity entity = dtoToEntity(dto);
            entities.add(entity);
        }
        return entities;

    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryCreateRequestDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());

        Set<ProductEntity> productEntities = new HashSet<>();
        categoryEntity.setProductList(productEntities);
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> requestDtoListToEntityList(List<CategoryCreateRequestDTO> categoryCreateRequestDTOS) {
        return null;
    }
}
