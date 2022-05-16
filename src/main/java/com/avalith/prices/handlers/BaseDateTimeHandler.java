package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

abstract class BaseDateTimeHandler implements IDateTimeHandler {
    protected BaseDateTimeHandler next;

    public void next(BaseDateTimeHandler baseDateTimeHandler) {
        next = baseDateTimeHandler;
    }

    @Override
    public Double procesar(LocalDateTime localDateTime) {
        return 0.0;
    }

    public LocalTime setHour(LocalDateTime localDateTime) {
        return LocalTime.from(localDateTime);
    }

    public DayOfWeek getDay(LocalDateTime localDateTime) {
        return DayOfWeek.from(localDateTime);
    }

    public LocalDateTime tempToLDT(Temporal temporal) {
        return LocalDateTime.from(temporal);
    }

    public LocalDate tempToLD(Temporal temporal) {
        return LocalDate.from(temporal);
    }

    public boolean verifyVacation(LocalDate date) {
        LocalDate vacationStartDate = LocalDate.of(2022, 8, 17);
        LocalDate vacationEndDate = LocalDate.of(2022, 8, 30);
        if (date.isBefore(vacationEndDate) && date.isAfter(vacationStartDate)) {
            return true;
        } else {
            return false;
        }
    }

}
