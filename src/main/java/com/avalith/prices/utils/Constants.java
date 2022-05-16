package com.avalith.prices.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Constants {
    private static Constants instance;
    public static Constants getInstance(){
        if (instance != null){
            instance = new Constants();
        }
        return instance;
    }
    public static final LocalDate vacationStartDate = LocalDate.of(2022, 8, 17);
    public static final LocalDate vacationEndDate = LocalDate.of(2022, 8, 30);
    public static final Double minusFive = -5.0;
    public static final Double plusTwenty = 20.0;
    public static final Double zero= 0.0;
    public static final Double minusTen = -10.0;
    public static final LocalTime twenty = LocalTime.of(20, 0);
    public static final LocalTime seven = LocalTime.of(7, 0);
    public static final Double minusTwentyFive = -25.0;
}
