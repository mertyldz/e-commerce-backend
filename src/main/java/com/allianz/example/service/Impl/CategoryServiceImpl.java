package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.DTO.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryCreateRequestDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService<CategoryEntity, CategoryDTO, CategoryCreateRequestDTO> {
    private final CategoryEntityRepository categoryEntityRepository;
    private final ProductEntityRepository productEntityRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAll() {
        return categoryMapper.entityListToDTOList(categoryEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        categoryEntityRepository.deleteByUuid(uuid);

    }

    @Override
    public CategoryDTO getByUUID(UUID uuid) {
        CategoryEntity category = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (category != null) {
            return categoryMapper.entityToDTO(category);
        } else {
            return null;
        }
    }

    @Override
    public CategoryDTO create(CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryEntity categoryEntity = categoryMapper.requestDTOToEntity(categoryCreateRequestDTO);
        categoryEntityRepository.save(categoryEntity);
        return categoryMapper.entityToDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateByUUID(UUID uuid, CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryEntity category = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (category != null) {
            category = categoryMapper.requestDTOToEntity(categoryCreateRequestDTO);
            categoryEntityRepository.save(category);
            return categoryMapper.entityToDTO(category);
        } else {
            return null;
        }
    }

    @Override
    public Boolean addProductListToCategory(UUID categoryUUID, List<UUID> productUuidList) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(categoryUUID).orElse(null);
        if (categoryEntity != null) {


            if (categoryEntity.getProductList() != null) {
                for (UUID productUUID : productUuidList) {
                    if (productEntityRepository.findByUuid(productUUID).isPresent()) {
                        categoryEntity.getProductList().add(productEntityRepository.findByUuid(productUUID).get());
                    }
                }
            } else {
                Set<ProductEntity> productEntityList = new HashSet<>();
                for (UUID productUUID : productUuidList) {
                    if (productEntityRepository.findByUuid(productUUID).isPresent()) {
                        productEntityList.add(productEntityRepository.findByUuid(productUUID).get());
                    }
                }
                categoryEntity.setProductList(productEntityList);
            }

            categoryEntityRepository.save(categoryEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
