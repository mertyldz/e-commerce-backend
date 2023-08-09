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
@AllArgsConstructor
public class BillServiceImpl implements BillService<BillEntity, BillDTO, BillRequestDTO> {
    private final BillEntityRepository billEntityRepository;
    private final OrderEntityRepository orderEntityRepository;
    private final BillMapper billMapper;

    @Override
    public Boolean addOrderToBill(UUID orderUUID, UUID billUUID) {
        BillEntity billEntity = billEntityRepository.findByUuid(billUUID).orElse(null);
        OrderEntity orderEntity = orderEntityRepository.findByUuid(orderUUID).orElse(null);
        if (billEntity != null && orderEntity != null) {
            billEntity.setOrder(orderEntity);
            billEntityRepository.save(billEntity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<BillDTO> getAll() {
        return billMapper.entityListToDTOList(billEntityRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        billEntityRepository.deleteByUuid(uuid);
    }

    @Override
    public BillDTO getByUUID(UUID uuid) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
            return billMapper.entityToDTO(billEntity);
        } else {
            return null;
        }
    }

    @Override
    public BillDTO create(BillRequestDTO billRequestDTO) {
        BillEntity billEntity = billMapper.requestDTOToEntity(billRequestDTO);
        billEntityRepository.save(billEntity);
        return billMapper.entityToDTO(billEntity);
    }

    @Override
    public BillDTO updateByUUID(UUID uuid, BillRequestDTO billRequestDTO) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
            billEntity = billMapper.requestDTOToEntity(billRequestDTO);
            billEntityRepository.save(billEntity);
            return billMapper.entityToDTO(billEntity);
        } else {
            return null;
        }
    }
}
