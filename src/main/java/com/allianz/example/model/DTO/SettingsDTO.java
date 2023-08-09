package com.allianz.example.model.DTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class SettingsDTO extends BaseDTO {

    private String key;
    private String value;
}
