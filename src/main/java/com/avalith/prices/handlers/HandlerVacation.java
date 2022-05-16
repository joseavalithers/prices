package com.avalith.prices.handlers;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import static com.avalith.prices.utils.Constants.minusTen;

public class HandlerVacation extends BaseDateTimeHandler{
    @Override
    public Double procesar(LocalDateTime localDateTime) {
        if (verifyVacation(tempToLD(localDateTime))){
            return minusTen;
        }else {
            return next.procesar(localDateTime);
        }
    }
}
