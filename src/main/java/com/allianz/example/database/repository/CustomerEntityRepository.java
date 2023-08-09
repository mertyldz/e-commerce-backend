package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEntityRepository extends BaseRepository<CustomerEntity> {
}
