
package com.avalith.prices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoLab   {
    private String motivo;
    private String tipo;
    private String info;
    private Integer dia;
    private Integer mes;
    private String id;
}
