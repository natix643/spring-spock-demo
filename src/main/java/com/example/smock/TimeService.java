package com.example.smock;

import org.springframework.stereotype.Service;

import java.time.*;

@Service
class TimeService {

    private final Clock clock;

    public TimeService(Clock clock) {
        this.clock = clock;
    }

    public LocalDate today() {
        return LocalDate.now(clock);
    }
}
