package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.DTO.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryCreateRequestDTO;
import com.allianz.example.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity, CategoryDTO, CategoryCreateRequestDTO, CategoryEntityRepository, CategoryMapper> implements CategoryService<CategoryEntity, CategoryDTO, CategoryCreateRequestDTO> {
    private final ProductEntityRepository productEntityRepository;

    public CategoryServiceImpl(CategoryEntityRepository repository, CategoryMapper mapper, ProductEntityRepository productEntityRepository) {
        super(repository, mapper);
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public Boolean addProductListToCategory(UUID categoryUUID, List<UUID> productUuidList) {
        CategoryEntity categoryEntity = repository.findByUuid(categoryUUID).orElse(null);
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
            repository.save(categoryEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public CategoryDTO create(CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryEntity categoryEntity = mapper.requestDTOToEntity(categoryCreateRequestDTO);
        repository.save(categoryEntity);
        return mapper.entityToDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateByUUID(UUID uuid, CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryEntity category = repository.findByUuid(uuid).orElse(null);
        if (category != null) {
            category = mapper.requestDTOToEntity(categoryCreateRequestDTO);
            repository.save(category);
            return mapper.entityToDTO(category);
        } else {
            return null;
        }
    }
}
