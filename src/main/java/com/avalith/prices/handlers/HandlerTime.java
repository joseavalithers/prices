package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.avalith.prices.utils.Constants.*;

public class HandlerTime extends BaseDateTimeHandler {

    @Override
    public Double procesar(LocalDateTime localDateTime ) {
        if (verifyHour(setHour(localDateTime)) && !(getDay(localDateTime) == DayOfWeek.WEDNESDAY)){
            return plusTwenty;
        }else {
            return zero;
        }
    }

    private Boolean verifyHour(LocalTime localTime) {
        return localTime.isBefore(seven) && localTime.isAfter(twenty);
    }
}
