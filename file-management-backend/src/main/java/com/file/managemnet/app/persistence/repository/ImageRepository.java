package com.file.managemnet.app.persistence.repository;

import com.file.managemnet.app.persistence.domain.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, UUID> {

    @Modifying
    @Query("update ImageEntity e set e.used = true where e.id = :id")
    void updateImageUser(UUID id);
}
