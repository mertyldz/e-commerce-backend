package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.DTO.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {
    @Autowired
    @Lazy
    PersonMapper personMapper;

    @Autowired
    @Lazy
    OrderMapper orderMapper;


    @Override
    public CustomerDTO entityToDTO(CustomerEntity customer) {
        CustomerDTO dto = new CustomerDTO();

        dto.setId(customer.getId());
        dto.setUuid(customer.getUuid());
        dto.setCreationDate(customer.getCreationDate());
        dto.setUpdatedDate(customer.getUpdatedDate());
        dto.setCompanyName(customer.getCompanyName());
        dto.setIsCorporate(customer.getIsCorporate());
        dto.setTaxNumber(customer.getTaxNumber());
        dto.setTaxOffice(customer.getTaxOffice());
        dto.setPerson(personMapper.entityToDTO(customer.getPerson()));
        dto.setOrderList(orderMapper.entityListToDTOList(customer.getOrderList()));

        return dto;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setPerson(personMapper.dtoToEntity(dto.getPerson()));
        entity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));

        return entity;
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

        for (CustomerDTO customerDTO : customerDTOS) {
            customerEntityList.add(dtoToEntity(customerDTO));
        }

        return customerEntityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity entity = new CustomerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCompanyName(dto.getCompanyName());
        entity.setIsCorporate(dto.getIsCorporate());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setPerson(personMapper.dtoToEntity(dto.getPerson()));

        return entity;
    }

    @Override
    public List<CustomerEntity> requestDtoListToEntityList(List<CustomerRequestDTO> customerRequestDTOS) {
        return null;
    }
}
