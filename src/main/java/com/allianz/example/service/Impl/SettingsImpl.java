package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.database.repository.SettingsRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.DTO.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.SettingsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SettingsImpl extends BaseServiceImpl<Settings, SettingsDTO, SettingsRequestDTO, SettingsRepository, SettingsMapper> implements SettingsService<Settings, SettingsDTO, SettingsRequestDTO> {
    public SettingsImpl(SettingsRepository repository, SettingsMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SettingsDTO create(SettingsRequestDTO settingsRequestDTO) {
        Settings settings = mapper.requestDTOToEntity(settingsRequestDTO);
        repository.save(settings);
        return mapper.entityToDTO(settings);
    }

    @Override
    public SettingsDTO updateByUUID(UUID uuid, SettingsRequestDTO settingsRequestDTO) {
        Settings settings = repository.findByUuid(uuid).orElse(null);
        if (settings != null) {
            settings = mapper.requestDTOToEntity(settingsRequestDTO);
            repository.save(settings);
            return mapper.entityToDTO(settings);
        } else {
            return null;
        }
    }

}
