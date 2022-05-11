package com.avalith.prices.calculator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DiscountWinterVacations implements Discount{
    @Override
    public Double getDiscount(LocalDateTime localDateTime) {
        LocalDate localDate = LocalDate.from(localDateTime);
        if (verifyVacation(localDate)){
            return -10.0;
        }
        else return 0.0;
    }

    private boolean verifyVacation(LocalDate date){
        LocalDate vacationStartDate = LocalDate.of(2022,8,17);
        LocalDate vacationEndDate = LocalDate.of(2022,8,30);
        if (date.isBefore(vacationEndDate) && date.isAfter(vacationStartDate)){
            return true;
        }else {
            return false;
        }
    }

}
