package com.app.hulkstore.Service;

import com.app.hulkstore.Controller.ProductoController;
import com.app.hulkstore.Dto.RequestVentaDto;
import com.app.hulkstore.Dto.RequestVentaGeneralDto;
import com.app.hulkstore.Dto.ResponseProductosDto;
import com.app.hulkstore.Dto.ResponseVentaProductoDto;
import com.app.hulkstore.Entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductoService {
    public ResponseProductosDto listarProductos();

    public ResponseVentaProductoDto venderProducto(RequestVentaGeneralDto requestVentaDto);
}
