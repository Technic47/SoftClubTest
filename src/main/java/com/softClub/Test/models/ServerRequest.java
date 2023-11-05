package com.softClub.Test.models;

import java.time.LocalDateTime;

public class ServerRequest {
    private LocalDateTime On_date;

    public ServerRequest(LocalDateTime on_date) {
        On_date = on_date;
    }

    public LocalDateTime getOn_date() {
        return On_date;
    }
}
