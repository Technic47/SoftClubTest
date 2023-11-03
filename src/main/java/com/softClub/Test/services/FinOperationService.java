package com.softClub.Test.services;

import com.softClub.Test.models.FinOperation;
import com.softClub.Test.repositories.FinOperationRepository;
import com.softClub.Test.services.abstracts.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class FinOperationService extends AbstractService<FinOperation, FinOperationRepository> {
    public FinOperationService(FinOperationRepository repository) {
        super(repository);
    }
}
