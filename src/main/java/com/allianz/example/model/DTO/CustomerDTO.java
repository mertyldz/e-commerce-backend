package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO extends BaseDTO {
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private PersonDTO person;
    private List<OrderDTO> orderList;
}
