package com.avalith.prices.calculator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DiscountWednesday implements Discount {
    @Override
    public Double getDiscount(LocalDateTime localDateTime) {
        DayOfWeek day = localDateTime.getDayOfWeek();
        if (day == DayOfWeek.WEDNESDAY) {
            return -25.0;
        } else return 0.0;
    }
}
