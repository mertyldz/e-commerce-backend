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
public class CustomerServiceImpl extends BaseServiceImpl<CustomerEntity, CustomerDTO, CustomerRequestDTO, CustomerEntityRepository, CustomerMapper> implements CustomerService<CustomerEntity, CustomerDTO, CustomerRequestDTO> {
    private final PersonEntityRepository personEntityRepository;
    private final OrderEntityRepository orderEntityRepository;

    public CustomerServiceImpl(CustomerEntityRepository repository, CustomerMapper mapper, PersonEntityRepository personEntityRepository, OrderEntityRepository orderEntityRepository) {
        super(repository, mapper);
        this.personEntityRepository = personEntityRepository;
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public Boolean addPersonToCustomer(UUID customerUUID, UUID personUUID) {
        CustomerEntity customer = repository.findByUuid(customerUUID).orElse(null);
        PersonEntity person = personEntityRepository.findByUuid(personUUID).orElse(null);

        if (customer != null && person != null) {
            customer.setPerson(person);
            repository.save(customer);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean addOrderListToCustomer(UUID customerUUID, List<UUID> orderUUIDList) {
        CustomerEntity customer = repository.findByUuid(customerUUID).orElse(null);
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
            repository.save(customer);
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean addOrderToCustomerOrderList(UUID customerUUID, UUID orderUUID) {
        CustomerEntity customer = repository.findByUuid(customerUUID).orElse(null);
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
            repository.save(customer);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public CustomerDTO create(CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = mapper.requestDTOToEntity(customerRequestDTO);
        repository.save(customer);
        return mapper.entityToDTO(customer);
    }

    @Override
    public CustomerDTO updateByUUID(UUID uuid, CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customer = repository.findByUuid(uuid).orElse(null);
        if (customer != null) {
            customer = mapper.requestDTOToEntity(customerRequestDTO);
            repository.save(customer);
            return mapper.entityToDTO(customer);
        } else {
            return null;
        }
    }
}
