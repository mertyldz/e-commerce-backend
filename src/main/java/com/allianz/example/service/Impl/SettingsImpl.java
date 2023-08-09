package com.allianz.example.service.Impl;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.database.repository.SettingsRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.DTO.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.IBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SettingsImpl implements IBaseService<Settings, SettingsDTO, SettingsRequestDTO> {
    private final SettingsMapper settingsMapper;
    private final SettingsRepository settingsRepository;

    @Override
    public List<SettingsDTO> getAll() {
        return settingsMapper.entityListToDTOList(settingsRepository.findAll());
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        settingsRepository.deleteByUuid(uuid);
    }

    @Override
    public SettingsDTO getByUUID(UUID uuid) {
        Settings settings = settingsRepository.findByUuid(uuid).orElse(null);
        if (settings != null) {
            return settingsMapper.entityToDTO(settings);
        } else {
            return null;
        }
    }

    @Override
    public SettingsDTO create(SettingsRequestDTO settingsRequestDTO) {
        Settings settings = settingsMapper.requestDTOToEntity(settingsRequestDTO);
        settingsRepository.save(settings);
        return settingsMapper.entityToDTO(settings);
    }

    @Override
    public SettingsDTO updateByUUID(UUID uuid, SettingsRequestDTO settingsRequestDTO) {
        Settings settings = settingsRepository.findByUuid(uuid).orElse(null);
        if (settings != null) {
            settings = settingsMapper.requestDTOToEntity(settingsRequestDTO);
            settingsRepository.save(settings);
            return settingsMapper.entityToDTO(settings);
        } else {
            return null;
        }

    }
}
