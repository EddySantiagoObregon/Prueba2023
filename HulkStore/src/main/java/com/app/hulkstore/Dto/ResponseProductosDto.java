package com.app.hulkstore.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseProductosDto {

    private ProductoDto productoDto;
    private List<ProductoDto> productoDtos;
    private String mensaje;
    private Integer codResponse;
    private String estado;
}
