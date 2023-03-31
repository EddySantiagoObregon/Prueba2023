package com.app.hulkstore.Controller;

import com.app.hulkstore.Entity.Factura;
import com.app.hulkstore.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping()
    public ResponseEntity<List<Factura>> listarFactura(){
        return new ResponseEntity<>(facturaService.listarFacturas(), HttpStatus.OK);
    }
}
