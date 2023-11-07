package com.softClub.Test.repositories;

import com.softClub.Test.models.FinOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FinOperationRepository extends AbstractRepository<FinOperation> {
    List<FinOperation> findByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);
}
