package com.avalith.prices.handlers;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class HandlerVacation extends BaseDateTimeHandler{
    @Override
    public Double procesar(LocalDateTime localDateTime) {
        if (verifyVacation(tempToLD(localDateTime))){
            return -10.0;
        }else {
            return next.procesar(localDateTime);
        }
    }
}
