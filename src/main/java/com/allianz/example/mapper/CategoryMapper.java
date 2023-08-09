package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.requestDTO.CategoryCreateRequestDTO;
import com.allianz.example.model.DTO.CategoryDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryCreateRequestDTO> {


    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(entity.getName());
        categoryDTO.setId(entity.getId());
        categoryDTO.setUuid(entity.getUuid());
        categoryDTO.setCreationDate(entity.getCreationDate());
        categoryDTO.setUpdatedDate(entity.getUpdatedDate());
        return categoryDTO;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());
        return categoryEntity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity category : categoryEntities) {
            categoryDTOList.add(entityToDTO(category));
        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        for (CategoryDTO categoryDTO : categoryDTOS) {
            categoryEntityList.add(dtoToEntity(categoryDTO));
        }
        return categoryEntityList;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryCreateRequestDTO dto) {
        CategoryEntity category = new CategoryEntity();
        category.setName(dto.getName());
        category.setUuid(dto.getUuid());
        category.setId(dto.getId());
        category.setUpdatedDate(dto.getUpdatedDate());
        category.setCreationDate(dto.getCreationDate());
        return category;
    }
}
