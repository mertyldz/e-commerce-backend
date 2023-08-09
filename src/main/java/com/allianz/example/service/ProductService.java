package com.allianz.example.service;

import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService<T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {

    public Boolean addTaxToProduct(UUID productUUID, UUID taxUUID);

    public Boolean addCategoryListToProduct(UUID productUUID, List<UUID> categoryUUDList);

    public Boolean addCategoryToProductCategoryList(UUID productUUID, UUID categoryUUID);
}
