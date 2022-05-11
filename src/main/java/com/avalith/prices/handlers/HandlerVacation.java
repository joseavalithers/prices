package com.avalith.prices.handlers;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class HandlerVacation extends BaseDateTimeHandler{
    @Override
    public void procesar(LocalDateTime localDateTime) {
        if (verifyVacation(tempToLD(localDateTime))){
            //setea el precio
        }else {
            //next
        }
    }
}
