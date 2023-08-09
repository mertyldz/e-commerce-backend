package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.DTO.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl extends BaseServiceImpl<AddressEntity, AddressDTO, AddressRequestDTO, AddressEntityRepository, AddressMapper> implements AddressService<AddressEntity, AddressDTO, AddressRequestDTO> {
    private final PersonEntityRepository personEntityRepository;

    public AddressServiceImpl(AddressEntityRepository repository, AddressMapper mapper, PersonEntityRepository personEntityRepository) {
        super(repository, mapper);
        this.addressEntityRepository = addressEntityRepository;
    }

    @Override
    public Boolean addPersonToAddress(UUID addressUUID, UUID personUUID) {
        AddressEntity addressEntity = repository.findByUuid(addressUUID).orElse(null);
        PersonEntity personEntity = personEntityRepository.findByUuid(personUUID).orElse(null);
        if (addressEntity != null && personEntity != null) {
            // Set person to address
            addressEntity.setPerson(personEntity);

            // Set address into person as well
            if (personEntity.getAddressEntityList() != null) {
                personEntity.getAddressEntityList().add(addressEntity);
            } else {
                List<AddressEntity> addressEntityList = new ArrayList<>();
                addressEntityList.add(addressEntity);
                personEntity.setAddressEntityList(addressEntityList);
            }
            repository.save(addressEntity);
            personEntityRepository.save(personEntity);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public AddressDTO create(AddressRequestDTO addressRequestDTO) {
        AddressEntity addressEntity = mapper.requestDTOToEntity(addressRequestDTO);
        repository.save(addressEntity);
        return mapper.entityToDTO(addressEntity);
    }

    @Override
    public AddressDTO updateByUUID(UUID uuid, AddressRequestDTO addressRequestDTO) {
        AddressEntity addressEntity = repository.findByUuid(uuid).orElse(null);
        if (addressEntity != null) {
            addressEntity = mapper.requestDTOToEntity(addressRequestDTO);
            repository.save(addressEntity);
            return mapper.entityToDTO(addressEntity);
        }
        return null;
    }
}

