package com.softClub.Test.repositories;

import com.softClub.Test.models.Currency;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends AbstractRepository<Currency> {
    Optional<Currency> findByVchCode(String VchCode);
}
