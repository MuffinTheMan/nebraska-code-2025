package org.refactoring.example2.after;

import java.time.LocalDateTime;

import lombok.NonNull;

public record LocalDateTimeRange(@NonNull LocalDateTime start, @NonNull LocalDateTime end) {
    /**
     * Constructs a LocalDateTimeRange instance representing a range of time between
     * a start and an end LocalDateTime. The start date and time must precede or be
     * equal to the end date and time.
     *
     * @param start the start of the date-time range; must not be null and must precede or equal end
     * @param end   the end of the date-time range; must not be null and must follow or equal start
     * @throws IllegalArgumentException if the start date-time is after the end date-time
     */
    public LocalDateTimeRange {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be on or before end date.");
        }
    }

    public boolean contains(@NonNull LocalDateTime date) {
        if (date.isBefore(start) || date.isAfter(end)) {
            return false;
        }
        return true;
        // Alternative, simplified code. Less readable, IMO:
        // return !date.isBefore(start) && !date.isAfter(end);
    }
}
