package com.app.hulkstore.Controller;

import com.app.hulkstore.Dto.RequestVentaDto;
import com.app.hulkstore.Dto.RequestVentaGeneralDto;
import com.app.hulkstore.Dto.ResponseProductosDto;
import com.app.hulkstore.Dto.ResponseVentaProductoDto;
import com.app.hulkstore.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/producto")
public class ProductoController{

    @Autowired
    private ProductoService productoService;

    @CrossOrigin("*")
    @GetMapping(value = "/listarProductos")
    public ResponseEntity<ResponseProductosDto> getProductos() throws IOException {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }
    @CrossOrigin("*")
    @PutMapping("/venderProducto")
    public ResponseEntity<ResponseVentaProductoDto> ventaProducto(@RequestBody RequestVentaGeneralDto requestVentaDto){
        return new ResponseEntity<>(productoService.venderProducto(requestVentaDto),HttpStatus.OK);
    }
}
