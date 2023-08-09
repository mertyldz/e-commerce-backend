package com.allianz.example.service.Impl;

import com.allianz.example.database.repository.BaseRepository;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseService;
import com.allianz.example.util.dbutil.BaseEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
public abstract class BaseServiceImpl
        <T extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseDTO,
                Repository extends BaseRepository<T>,
                Mapper extends IBaseMapper<DTO, T, RequestDTO>> implements IBaseService<T,DTO,RequestDTO> {

    protected final Repository repository;
    protected final  Mapper mapper;

    @Override
    public List<DTO> getAll() {
        return mapper.entityListToDTOList(repository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        repository.deleteByUuid(uuid);

    }

    @Override
    public DTO getByUUID(UUID uuid) {
        return mapper.entityToDTO(repository.findByUuid(uuid).orElse(null));
    }

    @Override
    public abstract DTO create(RequestDTO requestDTO);

    @Override
    public abstract DTO updateByUUID(UUID uuid, RequestDTO requestDTO);
}
