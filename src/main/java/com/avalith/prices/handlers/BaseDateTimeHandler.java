package com.avalith.prices.handlers;

import com.avalith.prices.utils.Constants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

import static com.avalith.prices.utils.Constants.*;

abstract class BaseDateTimeHandler implements IDateTimeHandler {
    protected BaseDateTimeHandler next;

    public void next(BaseDateTimeHandler baseDateTimeHandler) {
        next = baseDateTimeHandler;
    }

    @Override
    public Double procesar(LocalDateTime localDateTime) {
        return zero;
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
        return date.isBefore(vacationEndDate) && date.isAfter(vacationStartDate);
    }

}
