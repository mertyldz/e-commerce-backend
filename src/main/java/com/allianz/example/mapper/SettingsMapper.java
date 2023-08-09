package com.allianz.example.mapper;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.model.DTO.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettingsMapper implements IBaseMapper<SettingsDTO, Settings, SettingsRequestDTO> {
    @Override
    public SettingsDTO entityToDTO(Settings entity) {
        SettingsDTO settingsDTO = new SettingsDTO();

        settingsDTO.setId(entity.getId());
        settingsDTO.setUuid(entity.getUuid());
        settingsDTO.setCreationDate(entity.getCreationDate());
        settingsDTO.setUpdatedDate(entity.getUpdatedDate());
        settingsDTO.setKey(entity.getKey());
        settingsDTO.setValue(entity.getValue());

        return settingsDTO;
    }

    @Override
    public Settings dtoToEntity(SettingsDTO dto) {
        Settings settings = new Settings();

        settings.setId(dto.getId());
        settings.setUuid(dto.getUuid());
        settings.setCreationDate(dto.getCreationDate());
        settings.setUpdatedDate(dto.getUpdatedDate());
        settings.setKey(dto.getKey());
        settings.setValue(dto.getValue());

        return settings;
    }

    @Override
    public List<SettingsDTO> entityListToDTOList(List<Settings> settings) {
        List<SettingsDTO> settingsDTOList = new ArrayList<>();
        for (Settings settings1 : settings) {
            settingsDTOList.add(entityToDTO(settings1));
        }
        return settingsDTOList;
    }

    @Override
    public List<Settings> dtoListTOEntityList(List<SettingsDTO> settingsDTOS) {
        List<Settings> settingsList = new ArrayList<>();
        for (SettingsDTO settingsDTO : settingsDTOS) {
            settingsList.add(dtoToEntity(settingsDTO));
        }
        return settingsList;

    }

    @Override
    public Settings requestDTOToEntity(SettingsRequestDTO dto) {
        Settings settings = new Settings();

        settings.setId(dto.getId());
        settings.setUuid(dto.getUuid());
        settings.setCreationDate(dto.getCreationDate());
        settings.setUpdatedDate(dto.getUpdatedDate());
        settings.setKey(dto.getKey());
        settings.setValue(dto.getValue());

        return settings;
    }
}
