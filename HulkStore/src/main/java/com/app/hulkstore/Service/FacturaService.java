package com.app.hulkstore.Service;

import com.app.hulkstore.Entity.Factura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {

    public List<Factura> listarFacturas();
}
