package com.avalith.prices.api;

import com.avalith.prices.models.Year;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PriceController {

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
}
