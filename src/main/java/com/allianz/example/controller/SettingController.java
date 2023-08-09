package com.allianz.example.controller;

import com.allianz.example.model.DTO.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.Impl.SettingsImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
@AllArgsConstructor
public class SettingController {
    private final SettingsImpl settingsService;

    @PostMapping("create")
    public ResponseEntity<SettingsDTO> save(@RequestBody SettingsRequestDTO settingsRequestDTO){
        return new ResponseEntity<>(settingsService.create(settingsRequestDTO), HttpStatus.CREATED);
    }



}
