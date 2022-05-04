package com.avalith.prices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDate {
    Integer dia;
    Integer mes;
    Integer year;
    Integer hora;
    Integer minuto;
}
