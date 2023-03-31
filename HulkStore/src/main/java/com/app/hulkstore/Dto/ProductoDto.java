package com.app.hulkstore.Dto;

import com.app.hulkstore.Entity.Categoria;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private int cantidad;
    private String categoria;
    private String estado;
}
