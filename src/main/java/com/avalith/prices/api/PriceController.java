package com.avalith.prices.api;

import com.avalith.prices.calculator.DiscountCalculator;
import com.avalith.prices.models.MyDate;
import com.avalith.prices.models.Year;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PriceController {
    @Autowired
    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Operation(operationId = "getDiscount", summary = "get the discount as a double")
    @PostMapping("/nolabs/discount")
    public ResponseEntity<Double> getDiscount(@RequestBody LocalDateTime myDate){
        try{
            Double value = discountCalculator.getFinalPrice(myDate);
            return new ResponseEntity<>(value,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
