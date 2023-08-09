package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.DTO.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class ProductServiceImpl extends BaseServiceImpl<ProductEntity, ProductDTO, ProductRequestDTO, ProductEntityRepository, ProductMapper> implements ProductService<ProductEntity, ProductDTO, ProductRequestDTO> {
    private final TaxEntityRepository taxEntityRepository;
    private final CategoryEntityRepository categoryEntityRepository;

    public ProductServiceImpl(ProductEntityRepository repository, ProductMapper mapper,
                              TaxEntityRepository taxEntityRepository, CategoryEntityRepository categoryEntityRepository) {
        super(repository, mapper);
        this.taxEntityRepository = taxEntityRepository;
        this.categoryEntityRepository = categoryEntityRepository;
    }

    @Override
    public ProductDTO create(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = mapper.requestDTOToEntity(productRequestDTO);
        repository.save(productEntity);
        return mapper.entityToDTO(productEntity);
    }

    @Override
    public ProductDTO updateByUUID(UUID uuid, ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = repository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            productEntity = mapper.requestDTOToEntity(productRequestDTO);
            repository.save(productEntity);
            return mapper.entityToDTO(productEntity);
        } else {
            return null;
        }
    }

    @Override
    public Boolean addTaxToProduct(UUID productUUID, UUID taxUUID) {
        ProductEntity productEntity = repository.findByUuid(productUUID).orElse(null);
        TaxEntity taxEntity = taxEntityRepository.findByUuid(taxUUID).orElse(null);
        if (productEntity != null && taxEntity != null) {
            productEntity.setTax(taxEntity);
            repository.save(productEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean addCategoryListToProduct(UUID productUUID, List<UUID> categoryUUDList) {
        ProductEntity productEntity = repository.findByUuid(productUUID).orElse(null);
        if (productEntity != null) {
            if (productEntity.getCategoryList() != null) {
                for (UUID categoryUUID : categoryUUDList) {
                    if (categoryEntityRepository.findByUuid(categoryUUID).isPresent()) {
                        CategoryEntity category = categoryEntityRepository.findByUuid(categoryUUID).get();
                        productEntity.getCategoryList().add(category);
                        category.getProductList().add(productEntity);
                        categoryEntityRepository.save(category);

                    }
                }
                repository.save(productEntity);
            } else {
                Set<CategoryEntity> categoryList = new HashSet<>();
                for (UUID categoryUUID : categoryUUDList) {
                    if (categoryEntityRepository.findByUuid(categoryUUID).isPresent()) {
                        CategoryEntity category = categoryEntityRepository.findByUuid(categoryUUID).get();
                        categoryList.add(category);
                        category.getProductList().add(productEntity);
                        categoryEntityRepository.save(category);
                    }
                }
                productEntity.setCategoryList(categoryList);
                repository.save(productEntity);
            }

            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean addCategoryToProductCategoryList(UUID productUUID, UUID categoryUUID) {
        ProductEntity productEntity = repository.findByUuid(productUUID).orElse(null);
        CategoryEntity category = categoryEntityRepository.findByUuid(categoryUUID).orElse(null);
        if (productEntity != null && category != null) {
            if (productEntity.getCategoryList() != null) {
                productEntity.getCategoryList().add(category);
                category.getProductList().add(productEntity);
            } else {
                Set<CategoryEntity> categoryEntities = new HashSet<>();
                categoryEntities.add(category);
                productEntity.setCategoryList(categoryEntities);
                category.getProductList().add(productEntity);
            }
            repository.save(productEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


}
