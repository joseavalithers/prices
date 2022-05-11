package com.avalith.prices.handlers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

public class HandlerTime extends BaseDateTimeHandler {
    LocalTime twenty = LocalTime.of(20, 0);
    LocalTime seven = LocalTime.of(7, 0);

    @Override
    public void procesar(LocalDateTime localDateTime) {
        if (verifyHour(setHour(localDateTime))){
            //setea el descuento
        }else {
            //pasa al siguiente
        }
    }

    private Boolean verifyHour(LocalTime localTime) {
        return localTime.isBefore(seven) && localTime.isAfter(twenty);
    }
}
