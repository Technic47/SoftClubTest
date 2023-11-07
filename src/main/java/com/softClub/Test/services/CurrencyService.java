package com.softClub.Test.services;

import com.softClub.Test.exceptionhendlers.ResourceNotFoundException;
import com.softClub.Test.models.Currency;
import com.softClub.Test.repositories.CurrencyRepository;
import com.softClub.Test.services.abstracts.AbstractService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for finding and updating Currency entities.
 */
@Service
public class CurrencyService extends AbstractService<Currency, CurrencyRepository> {
    public CurrencyService(CurrencyRepository repository) {
        super(repository);
    }

    /**
     * Search Currency with specified VchCode.
     *
     * @param VchCode code.
     * @return result entity or throws ResourceNotFoundException;
     */
    public Currency findByVchCode(String VchCode) {
        Optional<Currency> result = repository.findByVchCode(VchCode);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Record with VchCode: " + VchCode + " not found");
        } else return result.get();
    }

    /**
     * Method for updating Currency entity.
     * Blocks service while running.
     *
     * @param currency entity to update.
     * @return updated entity.
     */
    public Currency update(Currency currency) {
        synchronized (this) {
            String vchCode = currency.getVchCode();
            try {
                Currency found = findByVchCode(vchCode);
                found.setVcode(currency.getVcode());
                found.setVchCode(currency.getVchCode());
                found.setVcurs(currency.getVcurs());
                found.setVname(currency.getVname());
                found.setVnom(currency.getVnom());
                found.setVunitRate(currency.getVunitRate());
                return repository.save(found);
            } catch (Exception e) {
                return repository.save(currency);
            }
        }
    }
}
