package com.avalith.prices.calculator;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    DiscountCalculator discountCalculator = new DiscountCalculator();
    LocalDate noWednesday = LocalDate.of(2022, 4, 29);
    LocalDate yesItsWednesday = LocalDate.of(2022, 4, 27);
    @Test
    void testVerifyWednesday(){
        assertTrue(discountCalculator.verifyWednesday(yesItsWednesday));
    }
    @Test
    void testVerifyWednesdayFalse(){
        assertFalse(discountCalculator.verifyWednesday(noWednesday));
    }


}