package com.softClub.Test.repositories;

import com.softClub.Test.models.FinOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinOperationRepository extends AbstractRepository<FinOperation> {
}
