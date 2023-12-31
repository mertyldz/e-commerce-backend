package com.allianz.example.database.repository;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SettingsRepository extends BaseRepository<Settings> {
}
