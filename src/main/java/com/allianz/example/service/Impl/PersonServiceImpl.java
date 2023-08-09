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
public class PersonServiceImpl extends BaseServiceImpl<PersonEntity, PersonDTO, PersonRequestDTO, PersonEntityRepository, PersonMapper> implements PersonService<PersonEntity, PersonDTO, PersonRequestDTO> {
    public PersonServiceImpl(PersonEntityRepository repository, PersonMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public PersonDTO create(PersonRequestDTO personRequestDTO) {
        PersonEntity personEntity = mapper.requestDTOToEntity(personRequestDTO);
        repository.save(personEntity);
        return mapper.entityToDTO(personEntity);
    }

    @Override
    public PersonDTO updateByUUID(UUID uuid, PersonRequestDTO personRequestDTO) {
        PersonEntity personEntity = repository.findByUuid(uuid).orElse(null);
        if (personEntity != null) {
            personEntity = mapper.requestDTOToEntity(personRequestDTO);
            repository.save(personEntity);
            return mapper.entityToDTO(personEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<PersonEntity> getPersonNameStartWith(String key) {
        return repository.findAllByNameStartingWith(key);

    }

    @Override
    public List<PersonEntity> getPersonNameIContains(String key) {
        return repository.findAllByNameContainsIgnoreCase(key);
    }

    @Override
    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname) {
        return repository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }
}
