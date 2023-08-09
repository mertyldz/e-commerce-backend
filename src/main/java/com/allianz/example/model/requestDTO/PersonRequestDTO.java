package com.allianz.example.model.requestDTO;

import com.allianz.example.model.DTO.AddressDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private List<AddressDTO> addressList;

}
