package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.DTO.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService<CustomerEntity, CustomerDTO, CustomerRequestDTO> {
    private final CustomerEntityRepository customerEntityRepository;
    private final PersonEntityRepository personEntityRepository;
    private final OrderEntityRepository orderEntityRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Boolean addPersonToCustomer(UUID customerUUID, UUID personUUID) {
        CustomerEntity customer = customerEntityRepository.findByUuid(customerUUID).orElse(null);
        PersonEntity person = personEntityRepository.findByUuid(personUUID).orElse(null);

        if (customer != null && person != null) {
            customer.setPerson(person);
            customerEntityRepository.save(customer);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean addOrderListToCustomer(UUID customerUUID, List<UUID> orderUUIDList) {
        CustomerEntity customer = customerEntityRepository.findByUuid(customerUUID).orElse(null);
        if (customer != null) {
            if (customer.getOrderList() != null) {
                for (UUID orderUUID : orderUUIDList) {
                    if (orderEntityRepository.findByUuid(orderUUID).isPresent()) {
                        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).get();
                        customer.getOrderList().add(orderEntity);
                        orderEntity.setCustomer(customer);
                        orderEntityRepository.save(orderEntity);
                    }
                }
            } else {
                List<OrderEntity> orderEntityList = new ArrayList<>();
                for (UUID orderUUID : orderUUIDList) {
                    if (orderEntityRepository.findByUuid(orderUUID).isPresent()) {
                        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).get();
                        orderEntityList.add(orderEntity);
                        orderEntity.setCustomer(customer);

                        orderEntityRepository.save(orderEntity);
                    }
                }
                customer.setOrderList(orderEntityList);
            }
            customerEntityRepository.save(customer);
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean addOrderToCustomerOrderList(UUID customerUUID, UUID orderUUID) {
        CustomerEntity customer = customerEntityRepository.findByUuid(customerUUID).orElse(null);
        OrderEntity order = orderEntityRepository.findByUuid(orderUUID).orElse(null);

        if (customer != null && order != null) {
            if (customer.getOrderList() != null) {
                customer.getOrderList().add(order);
            } else {
                List<OrderEntity> orderEntityList = new ArrayList<>();
                orderEntityList.add(order);
                customer.setOrderList(orderEntityList);
            }
            order.setCustomer(customer);
            orderEntityRepository.save(order);
            customerEntityRepository.save(customer);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerMapper.entityListToDTOList(customerEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        customerEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public CustomerDTO getByUUID(UUID uuid) {
        if (customerEntityRepository.findByUuid(uuid).isPresent()) {
            CustomerEntity customer = customerEntityRepository.findByUuid(uuid).get();
            return customerMapper.entityToDTO(customer);
        } else {
            return null;
        }
    }

    @Override
    public CustomerDTO create(CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = customerMapper.requestDTOToEntity(customerRequestDTO);
        customerEntityRepository.save(customer);
        return customerMapper.entityToDTO(customer);
    }

    @Override
    public CustomerDTO updateByUUID(UUID uuid, CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customer != null) {
            customer = customerMapper.requestDTOToEntity(customerRequestDTO);
            customerEntityRepository.save(customer);
            return customerMapper.entityToDTO(customer);
        } else {
            return null;
        }
    }

}
