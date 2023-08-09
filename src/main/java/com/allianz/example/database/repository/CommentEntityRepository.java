package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface CommentEntityRepository extends BaseRepository<CommentEntity> {
}
