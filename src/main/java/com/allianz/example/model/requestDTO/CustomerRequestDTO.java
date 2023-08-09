package com.allianz.example.model.requestDTO;

import com.allianz.example.model.DTO.PersonDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private PersonDTO person;
}
