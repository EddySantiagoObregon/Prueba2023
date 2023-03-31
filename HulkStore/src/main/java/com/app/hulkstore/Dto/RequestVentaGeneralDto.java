package com.app.hulkstore.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class RequestVentaGeneralDto {
    private List<RequestVentaDto> venta;
    private int cantidadTotalVentaGeneral;
    private double precioTotal;
}
