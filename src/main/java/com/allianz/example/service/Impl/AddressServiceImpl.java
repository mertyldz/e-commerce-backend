package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.DTO.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService<AddressEntity, AddressDTO, AddressRequestDTO> {

    // Constructor injection
    private final AddressEntityRepository addressEntityRepository;
    private final PersonEntityRepository personEntityRepository;
    private final AddressMapper addressMapper;


    @Override
    public Boolean addPersonToAddress(UUID addressUUID, UUID personUUID) {

        AddressEntity addressEntity = addressEntityRepository.findByUuid(addressUUID).orElse(null);
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
            addressEntityRepository.save(addressEntity);
            personEntityRepository.save(personEntity);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public List<AddressDTO> getAll() {
        List<AddressEntity> addressEntityList = addressEntityRepository.findAll();
        return addressMapper.entityListToDTOList(addressEntityList);
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        addressEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public AddressDTO getByUUID(UUID uuid) {
        Optional<AddressEntity> addressEntityOptional = addressEntityRepository.findByUuid(uuid);
        if (addressEntityOptional.isPresent()) {
            return addressMapper.entityToDTO(addressEntityOptional.get());
        } else {
            return null;
        }

    }

    @Override
    public AddressDTO create(AddressRequestDTO addressRequestDTO) {
        AddressEntity addressEntity = addressMapper.requestDTOToEntity(addressRequestDTO);

        addressEntityRepository.save(addressEntity);

        return addressMapper.entityToDTO(addressEntity);
    }

    @Override
    public AddressDTO updateByUUID(UUID uuid, AddressRequestDTO addressRequestDTO) {
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity != null) {
            addressEntity = addressMapper.requestDTOToEntity(addressRequestDTO);
            addressEntityRepository.save(addressEntity);
            return addressMapper.entityToDTO(addressEntity);
        }
        return null;
    }
}
