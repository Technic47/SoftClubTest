package com.softClub.Test.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CurrencyUpdateService {
    @Scheduled(cron= "${cron.profile}")
    @Async
    public void update(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Help me!!!");
    }
}
