package org.refactoring.example2.before;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.Getter;

public class LincolnFireworksLauncher {
    private final int CURRENT_YEAR = LocalDate.now(ZoneId.of("America/Chicago")).getYear();
    @Getter
    private int launchCounter = 0;

    public void launch() {
        if (
            (!LocalDateTime.now(ZoneId.of("America/Chicago")).isBefore(LocalDateTime.of(CURRENT_YEAR, 7, 3, 8, 0)) && !LocalDateTime.now(ZoneId.of("America/Chicago")).isAfter(LocalDateTime.of(CURRENT_YEAR, 7, 3, 23, 0)))
            ||
            (!LocalDateTime.now(ZoneId.of("America/Chicago")).isBefore(LocalDateTime.of(CURRENT_YEAR, 7, 4, 8, 0)) && !LocalDateTime.now(ZoneId.of("America/Chicago")).isAfter(LocalDateTime.of(CURRENT_YEAR, 7, 4, 23, 59)))
        ) {
            launchCounter++;
        }
    }
}
