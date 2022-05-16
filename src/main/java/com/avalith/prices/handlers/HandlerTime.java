package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HandlerTime extends BaseDateTimeHandler {
    LocalTime twenty = LocalTime.of(20, 0);
    LocalTime seven = LocalTime.of(7, 0);

    @Override
    public Double procesar(LocalDateTime localDateTime ) {
        if (verifyHour(setHour(localDateTime)) && !(getDay(localDateTime) == DayOfWeek.WEDNESDAY)){
            return 20.0;
        }else {
            return next.procesar(localDateTime);
        }
    }

    private Boolean verifyHour(LocalTime localTime) {
        return localTime.isBefore(seven) && localTime.isAfter(twenty);
    }
}
