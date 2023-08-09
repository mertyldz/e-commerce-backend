package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;

public interface PersonService <T extends BaseEntity, ResponseDTO extends BaseDTO, RequestDTO extends BaseDTO>
        extends IBaseService<T, ResponseDTO, RequestDTO> {
    public List<PersonEntity> getPersonNameStartWith(String key);
    public List<PersonEntity> getPersonNameIContains(String key);
    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname);
}
