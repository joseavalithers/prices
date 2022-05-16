package com.avalith.prices.handlers;

import com.avalith.prices.models.Year;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class HandlerNoLabs extends BaseDateTimeHandler {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://nolaborables.com.ar/api/v2/feriados/2022";
    @Override
    public Double procesar(LocalDateTime localDateTime) {
        if (!verifyIfIsNotLab(localDateTime)){
            return -5.0;
        }else {
            return next.procesar(localDateTime);
        }
    }
    public Optional<Year> getYearFromApi() {
        Year response = restTemplate.getForObject(fooResourceUrl, Year.class);
        Optional<Year> opt = Optional.ofNullable(response);
        if (opt.isEmpty()) {
            return Optional.empty();
        }
        return opt;
    }
    public List<LocalDate> convertAllYearToDate(Year year) {
        List<LocalDate> list = new ArrayList<>();

        year.stream().forEach(
                noLab -> {
                    //String nolabString = "2022" + "-" + noLab.getMes().toString() + "-" + noLab.getDia().toString();
                    LocalDate date = LocalDate.of(2022,noLab.getMes(),noLab.getDia());
                    list.add(date);
                }
        );
        return list;
    }
    public Boolean verifyIfIsNotLab(LocalDateTime localDateTime){
        LocalDate date = LocalDate.from(localDateTime);
        Optional<Year> opt = getYearFromApi();
        AtomicReference<Boolean> value = new AtomicReference<>(false);
        if (opt.isPresent()) {
            Year year = opt.get();
            List<LocalDate> list = convertAllYearToDate(year);
            System.out.println(list);
            list.stream().forEach(
                    element -> {
                        if (element.equals(date)) {
                            value.set(true);
                        }
                    });
        }
        return value.get();
    }
}
