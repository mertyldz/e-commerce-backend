package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.DTO.AddressDTO;
import com.allianz.example.model.DTO.CustomerDTO;
import com.allianz.example.model.DTO.PersonDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.IBaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {


    @Override
    public CustomerDTO entityToDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setUuid(customer.getUuid());
        customerDTO.setCreationDate(customer.getCreationDate());
        customerDTO.setUpdatedDate(customer.getUpdatedDate());
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setIsCorporate(customer.getIsCorporate());
        customerDTO.setTaxNumber(customer.getTaxNumber());
        customerDTO.setTaxOffice(customer.getTaxOffice());

        return customerDTO;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(dto.getId());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            customerDTOList.add(entityToDTO(customerEntity));
        }

        return customerDTOList;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> customerEntityList = new ArrayList<>();
        for(CustomerDTO customerDTO : customerDTOS){
            customerEntityList.add(dtoToEntity(customerDTO));
        }
        return customerEntityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(dto.getId());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }
}
