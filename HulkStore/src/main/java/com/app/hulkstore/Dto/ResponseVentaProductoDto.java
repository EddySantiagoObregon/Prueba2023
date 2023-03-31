package com.app.hulkstore.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ResponseVentaProductoDto {
    private String mensaje;
    private Integer codResponse;
    private String estado;
}
