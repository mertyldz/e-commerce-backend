package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

}
