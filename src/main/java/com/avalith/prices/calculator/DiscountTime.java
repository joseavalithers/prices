package com.avalith.prices.calculator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountTime implements Discount {
    @Override
    public Double getDiscount(LocalDateTime localDateTime) {
        DayOfWeek day = DayOfWeek.from(localDateTime);
        LocalTime time = LocalTime.from(localDateTime);
        if (day != DayOfWeek.WEDNESDAY && time.isAfter(LocalTime.of(20, 0)) && time.isBefore(LocalTime.of(7, 0))) {
            return 10.0;
        } else return 0.0;
    }
}
