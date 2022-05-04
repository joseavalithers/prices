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


    @PostMapping("/price")
    public ResponseEntity<Double> getPrice(@RequestParam Double price, @RequestParam String date){
        return new ResponseEntity<>(1.2, HttpStatus.OK);
    }
    @GetMapping("/nolabs")
    public ResponseEntity<Year> getMonths(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://nolaborables.com.ar/api/v2/feriados/2022";
        Year response = restTemplate.getForObject(fooResourceUrl, Year.class);
        Optional<Year> opt = Optional.ofNullable(response);
        if (opt.isEmpty()){
            return null;
        }
        return opt.map(value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @GetMapping("/nolabs/verify")
    public ResponseEntity<Boolean> isNoLab(@RequestParam Integer dia, @RequestParam Integer mes, @RequestParam Integer year){
        LocalDate date = LocalDate.of(year, mes, dia);
        Boolean value = false;
        value = discountCalculator.verifyNoLabs(date);
        value = discountCalculator.verifyWednesday(date);
        return new ResponseEntity<>(value,HttpStatus.OK);
    }

    @Operation(operationId = "getDiscount", summary = "get the discount as a double")
    @GetMapping("/nolabs/discount")
    public ResponseEntity<Double> getDiscount(@RequestBody MyDate myDate){
        try{
            LocalDateTime localDateTime = LocalDateTime.of(myDate.getYear(),myDate.getMes(),myDate.getDia(),myDate.getHora(),myDate.getMinuto());
            Double value = discountCalculator.getFinalPrice(localDateTime);
            return new ResponseEntity<>(value,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
