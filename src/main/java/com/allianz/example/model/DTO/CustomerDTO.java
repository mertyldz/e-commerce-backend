package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class CustomerDTO extends BaseDTO {
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
}
