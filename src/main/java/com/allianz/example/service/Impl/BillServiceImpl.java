package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.DTO.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl extends BaseServiceImpl<BillEntity, BillDTO, BillRequestDTO, BillEntityRepository, BillMapper> implements BillService<BillEntity, BillDTO, BillRequestDTO> {
    private final OrderEntityRepository orderEntityRepository;

    public BillServiceImpl(BillEntityRepository repository, BillMapper mapper, OrderEntityRepository orderEntityRepository) {
        super(repository, mapper);
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public Boolean addOrderToBill(UUID orderUUID, UUID billUUID) {
        BillEntity billEntity = repository.findByUuid(billUUID).orElse(null);
        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).orElse(null);
        if (billEntity != null && orderEntity != null) {
            billEntity.setOrder(orderEntity);
            repository.save(billEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public BillDTO create(BillRequestDTO billRequestDTO) {
        BillEntity billEntity = mapper.requestDTOToEntity(billRequestDTO);
        repository.save(billEntity);
        return mapper.entityToDTO(billEntity);
    }

    @Override
    public BillDTO updateByUUID(UUID uuid, BillRequestDTO billRequestDTO) {
        BillEntity billEntity = repository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
            billEntity = mapper.requestDTOToEntity(billRequestDTO);
            repository.save(billEntity);
            return mapper.entityToDTO(billEntity);
        } else {
            return null;
        }
    }
}
