package com.softClub.Test.services;

import com.softClub.Test.models.Currency;
import com.softClub.Test.repositories.CurrencyRepository;
import com.softClub.Test.services.abstracts.AbstractService;

public class CurrencyService extends AbstractService<Currency, CurrencyRepository> {
    public CurrencyService(CurrencyRepository repository) {
        super(repository);
    }
}
