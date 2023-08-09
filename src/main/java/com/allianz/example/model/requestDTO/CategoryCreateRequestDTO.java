package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class CategoryCreateRequestDTO extends BaseDTO {
    private String name;
}
