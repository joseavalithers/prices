package com.avalith.prices.api;

import com.avalith.prices.calculator.DiscountCalculator;
import com.avalith.prices.models.MyDate;
import com.avalith.prices.models.Year;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Formatter;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PriceController {
    @Autowired
    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Operation(operationId = "getDiscount", summary = "get the discount as a double")
    @PostMapping("/nolabs/discount")
    public ResponseEntity<Double> getDiscount(@RequestParam String myDate) {
        //'2011-12-03T10:15:30'
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime date = dateTimeFormat.parse(myDate, LocalDateTime::from);
        try {
            Double value = discountCalculator.getDiscount(date);
            return new ResponseEntity<>(value, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
