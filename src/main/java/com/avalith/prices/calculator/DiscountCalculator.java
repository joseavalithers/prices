package com.avalith.prices.calculator;


import com.avalith.prices.handlers.HandlerNoLabs;
import com.avalith.prices.handlers.HandlerTime;
import com.avalith.prices.handlers.HandlerVacation;
import com.avalith.prices.handlers.HandlerWednesday;

import java.time.LocalDateTime;

public class DiscountCalculator implements Discount {

    public Double discount = 0.0;
    private HandlerWednesday handler1 = new HandlerWednesday();
    private HandlerVacation handler2 = new HandlerVacation();
    private HandlerNoLabs handler3 = new HandlerNoLabs();
    private HandlerTime handler4 = new HandlerTime();

    public DiscountCalculator() {
        handler1.next(handler2);
        handler2.next(handler3);
        handler3.next(handler4);
    }

    //la regla es que se aplica el descuento mas grande solamente y si se aplica el aumento no se aplica descuento


    @Override
    public Double getDiscount(LocalDateTime localDateTime) {
        return handler1.procesar(localDateTime);
    }
}
