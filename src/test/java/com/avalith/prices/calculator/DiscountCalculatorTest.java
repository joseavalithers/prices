package com.avalith.prices.calculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    DiscountCalculator discountCalculator = new DiscountCalculator();
    LocalDate noWednesday = LocalDate.of(2022, 4, 29);
    LocalDate yesItsWednesday = LocalDate.of(2022, 4, 27);
    LocalDate vacationDate = LocalDate.of(2022, 8, 18);
    LocalDate noVacationDate = LocalDate.of(2022, 8, 10);
    LocalDateTime vacationDateTime = LocalDateTime.of(2022,8,18,21,0);
    LocalDateTime noVacationDateTime = LocalDateTime.of(2022,8,1,19,0);
    LocalDateTime wednesday = LocalDateTime.of(2022,5,4,19,0);
    LocalDateTime nolabday = LocalDateTime.of(2022,5,25,19,0);
    LocalDateTime twentyone = LocalDateTime.of(2022,4,4,21,0);


    @Test
    void testVerifyWednesday() {
        assertTrue(discountCalculator.verifyWednesday(yesItsWednesday));
    }

    @Test
    void testVerifyWednesdayFalse() {
        assertFalse(discountCalculator.verifyWednesday(noWednesday));
    }

    @Test
    void testNoLab() {
        LocalDate date = LocalDate.of(2022, 7, 9);
        assertEquals(true, discountCalculator.verifyNoLabs(date));
    }

    @Test
    void testVacation() {
        assertTrue(discountCalculator.verifyVacation(vacationDate));
    }

    @Test
    void testNoVacation() {
        assertFalse(discountCalculator.verifyVacation(noVacationDate));
    }
    @Test
    void price() {
        assertEquals(-10.0,discountCalculator.getFinalPrice(vacationDateTime));
    }
    @Test
    void priceNoVacation(){
        assertEquals(0.0,discountCalculator.getFinalPrice(noVacationDateTime));
    }
    @Test
    void priceWednesday(){
        assertEquals(-25.0,discountCalculator.getFinalPrice(wednesday));
    }
    @Test
    void nolabDayTest(){
        assertEquals(-5.0,discountCalculator.getFinalPrice(nolabday));
    }
    @Test
    void twentyoneTest(){
        assertEquals(+20.0,discountCalculator.getFinalPrice(twentyone));
    }
}