package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.avalith.prices.utils.Constants.minusTwentyFive;

public class HandlerWednesday extends BaseDateTimeHandler{
    @Override
    public Double procesar(LocalDateTime localDateTime ) {
        if (getDay(localDateTime) == DayOfWeek.WEDNESDAY){
            return minusTwentyFive;
        }else {
            return next.procesar(localDateTime);
        }
    }
}
