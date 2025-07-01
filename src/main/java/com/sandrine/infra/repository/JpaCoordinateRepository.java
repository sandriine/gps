package com.sandrine.infra.repository;

import com.sandrine.infra.entity.CoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCoordinateRepository extends JpaRepository<CoordinateEntity, Long> {
}
