package com.sandrine.infra.repository;

import com.sandrine.infra.document.CoordinateDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinateRepository extends MongoRepository<CoordinateDocument, String> {}
