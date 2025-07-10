package org.refactoring.example2.intermediate;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.AccessLevel;
import lombok.Getter;

public class LincolnFireworksLauncher {
    public static final ZoneId CST = ZoneId.of("America/Chicago");
    @Getter(AccessLevel.PACKAGE)
    private final Clock clock;
    @Getter(AccessLevel.PACKAGE)
    private final int currentYear;
    @Getter
    private int launchCounter = 0;

    public LincolnFireworksLauncher(Clock clock) {
        this.clock = clock;
        this.currentYear = LocalDate.now(clock.withZone(CST)).getYear();
    }

    public LincolnFireworksLauncher() {
        this(Clock.system(CST));
    }

    public void launch() {
        if (
            (!LocalDateTime.now(clock).isBefore(LocalDateTime.of(currentYear, 7, 3, 8, 0)) && !LocalDateTime.now(clock).isAfter(LocalDateTime.of(currentYear, 7, 3, 23, 0)))
            ||
            (!LocalDateTime.now(clock).isBefore(LocalDateTime.of(currentYear, 7, 4, 8, 0)) && !LocalDateTime.now(clock).isAfter(LocalDateTime.of(currentYear, 7, 4, 23, 59)))
        ) {
            launchCounter++;
        }
    }
}
