package org.refactoring.example2.after;

import java.time.LocalDateTime;

import lombok.NonNull;

public record LocalDateTimeRange(@NonNull LocalDateTime start, @NonNull LocalDateTime end) {
    public LocalDateTimeRange(@NonNull LocalDateTime start, @NonNull LocalDateTime end) {
        this.start = start.isBefore(end) ? start : end;
        this.end = end.isAfter(start) ? end : start;
    }

    public boolean contains(@NonNull LocalDateTime date) {
        if (date.isBefore(start) || date.isAfter(end)) {
            return false;
        }
        return true;
    }
}
