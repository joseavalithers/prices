package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class HandlerWednesday extends BaseDateTimeHandler{
    @Override
    public Double procesar(LocalDateTime localDateTime ) {
        if (getDay(localDateTime) == DayOfWeek.WEDNESDAY){
            return -25.0;
        }else {
            return next.procesar(localDateTime);
        }
    }
}
