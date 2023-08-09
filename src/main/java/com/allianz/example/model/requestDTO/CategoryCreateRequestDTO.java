package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryCreateRequestDTO extends BaseDTO {
    private String name;
    private Set<ProductEntity> productList = new HashSet<>();
}
