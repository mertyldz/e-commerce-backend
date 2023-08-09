package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.DTO.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService<PersonEntity, PersonDTO, PersonRequestDTO> {

    private final PersonEntityRepository personEntityRepository;
    private final PersonMapper personMapper;

    public List<PersonEntity> getPersonNameStartWith(String key) {
        return personEntityRepository.findAllByNameStartingWith(key);
    }

    public List<PersonEntity> getPersonNameIContains(String key) {
        return personEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname) {
        return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

    @Override
    public List<PersonDTO> getAll() {
        return personMapper.entityListToDTOList(personEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        personEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public PersonDTO getByUUID(UUID uuid) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity != null) {
            return personMapper.entityToDTO(personEntity);
        } else {
            return null;
        }
    }

    @Override
    public PersonDTO create(PersonRequestDTO personRequestDTO) {
        PersonEntity personEntity = personMapper.requestDTOToEntity(personRequestDTO);
        personEntityRepository.save(personEntity);
        return personMapper.entityToDTO(personEntity);
    }

    @Override
    public PersonDTO updateByUUID(UUID uuid, PersonRequestDTO personRequestDTO) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity != null) {
            personEntity = personMapper.requestDTOToEntity(personRequestDTO);
            personEntityRepository.save(personEntity);
            return personMapper.entityToDTO(personEntity);
        } else {
            return null;
        }
    }
}
