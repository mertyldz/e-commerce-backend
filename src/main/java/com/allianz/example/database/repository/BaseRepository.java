package com.allianz.example.database.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository <T> extends JpaRepository<T, Long> {
    @Transactional
    void deleteByUuid(UUID uuid);

    Optional<T> findByUuid(UUID uuid);
}
