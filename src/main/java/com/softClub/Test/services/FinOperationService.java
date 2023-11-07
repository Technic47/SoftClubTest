package com.softClub.Test.services;

import com.softClub.Test.models.FinOperation;
import com.softClub.Test.repositories.FinOperationRepository;
import com.softClub.Test.services.abstracts.AbstractService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FinOperationService extends AbstractService<FinOperation, FinOperationRepository> {
    public FinOperationService(FinOperationRepository repository) {
        super(repository);
    }

    public List<FinOperation> findInPeriod(LocalDateTime dateTime, LocalDateTime dateTime2) {
        return repository.findByDateTimeBetween(dateTime, dateTime2);
    }
}
