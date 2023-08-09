package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {
    private String name;
    private String surname;
    private String tc;
    private String email;
    private String shopName;
    private String taxNumber;
    private String taxOffice;
}
