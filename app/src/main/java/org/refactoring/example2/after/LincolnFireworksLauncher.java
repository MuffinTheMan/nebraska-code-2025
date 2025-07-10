package org.refactoring.example2.after;

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
    private final LocalDateTimeRange JULY_3_HOURS;
    private final LocalDateTimeRange JULY_4_HOURS;

    public LincolnFireworksLauncher(Clock clock) {
        this.clock = clock;
        this.currentYear = LocalDate.now(clock.withZone(CST)).getYear();
        this.JULY_3_HOURS = new LocalDateTimeRange(LocalDateTime.of(currentYear, 7, 3, 8, 0), LocalDateTime.of(currentYear, 7, 3, 23, 0));
        this.JULY_4_HOURS = new LocalDateTimeRange(LocalDateTime.of(currentYear, 7, 4, 8, 0), LocalDateTime.of(currentYear, 7, 4, 23, 59));
    }

    public LincolnFireworksLauncher() {
        this(Clock.system(CST));
    }

    public void launch() {
        final LocalDateTime currentTime = LocalDateTime.now(clock);
        if (JULY_3_HOURS.contains(currentTime) || JULY_4_HOURS.contains(currentTime)) {
            launchCounter++;
        }
    }
}
