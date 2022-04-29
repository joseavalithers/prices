package com.avalith.prices.calculator;

import com.avalith.prices.models.Year;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class DiscountCalculator {
    public Optional<Year> getYearFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://nolaborables.com.ar/api/v2/feriados/2022";
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

    public Boolean verifyNoLabs(LocalDate date) {
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
    public boolean verifyWednesday(Integer dia, Integer mes,Integer year){
        LocalDate date = LocalDate.of(year,mes,dia);
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.WEDNESDAY;
    }
    public boolean verifyWednesday(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.WEDNESDAY;
    }
    public boolean verifyTime(Integer hour, Integer minutes){
        LocalTime localtime = LocalTime.of(hour,minutes);
        return localtime.isAfter(LocalTime.of(20, 0));
    }
    //vacaciones de invierno 18/07-29/07
    public boolean verifyVacation(LocalDate date){
        return date.isBefore(LocalDate.of(2022, 7, 30)) &&
                date.isAfter(LocalDate.of(2022, 7, 17));
    }
    //la regla es que se aplica el descuento mas grande solamente y si se aplica el aumento no se aplica descuento
    public Double getFinalPrice(LocalDateTime date){
        LocalDate localDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDayOfMonth());
        if (verifyVacation(localDate)){
            return -10.0;
        }
        if (verifyNoLabs(localDate)){
            return -5.0;
        }
        if (verifyWednesday(localDate )){
            return -25.0;
        }
        return +20.0;
    }

}
