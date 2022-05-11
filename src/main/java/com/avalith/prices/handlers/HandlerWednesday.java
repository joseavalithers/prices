package com.avalith.prices.handlers;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class HandlerWednesday extends BaseDateTimeHandler{
    @Override
    public void procesar(LocalDateTime localDateTime) {
        if (getDay(localDateTime) == DayOfWeek.WEDNESDAY){
            //setea el descuento a tal
        }else {
            //procesa el siguiente
        }
    }
}
