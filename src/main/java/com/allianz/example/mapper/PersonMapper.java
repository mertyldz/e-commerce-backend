package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.DTO.AddressDTO;
import com.allianz.example.model.DTO.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.IBaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {

    private final AddressMapper addressMapper;


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());

        return personDTO;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setUuid(dto.getUuid());
        personEntity.setId(dto.getId());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setTc(dto.getTc());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());

        List<AddressEntity> addressEntityList = new ArrayList<>();
        for (AddressDTO addressDTO : dto.getAddressList()) {
            addressEntityList.add(addressMapper.dtoToEntity(addressDTO));
        }

        personEntity.setAddressEntityList(addressEntityList);
        return personEntity;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (PersonEntity person : personEntities) {
            personDTOList.add(entityToDTO(person));
        }

        return personDTOList;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntityList = new ArrayList<>();

        for (PersonDTO personDTO : personDTOS) {
            personEntityList.add(dtoToEntity(personDTO));
        }
        return personEntityList;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setId(dto.getId());
        personEntity.setUuid(dto.getUuid());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setTc(dto.getTc());
        personEntity.setBirthYear(dto.getBirthYear());

        return personEntity;
    }

    @Override
    public List<PersonEntity> requestDtoListToEntityList(List<PersonRequestDTO> personRequestDTOS) {
        return null;
    }
}
