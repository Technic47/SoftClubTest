package com.softClub.Test.services;

import com.softClub.Test.client.models.generated.ValuteData;
import com.softClub.Test.models.CurrencyBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyUpdateService {
    private final DailyCurrencyClient dailyCurrencyClient;
    private final CurrencyService service;

    public CurrencyUpdateService(DailyCurrencyClient dailyCurrencyClient, CurrencyService service) {
        this.dailyCurrencyClient = dailyCurrencyClient;
        this.service = service;
    }

    @Scheduled(cron = "${cron.profile1}")
    @Async
    public void update1() {
        updateCurrencies();
    }

//    @Scheduled(cron = "${cron.profile2}")
//    @Async
//    public void update2() {
//        updateCurrencies();
//    }

    private void updateCurrencies(){
        try {
            List<ValuteData.ValuteCursOnDate> cursOnDate = dailyCurrencyClient.getCursOnDate(LocalDateTime.now());
            cursOnDate.forEach(item -> service.update(
                    new CurrencyBuilder()
                            .setVchCode(item.getVchCode())
                            .setVcode(item.getVcode())
                            .setVcurs(item.getVcurs())
                            .setVname(item.getVname())
                            .setVnom(item.getVnom())
                            .setVunitRate(item.getVunitRate())
                            .createCurrency()));
            System.out.println("Currencies are updated.");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
