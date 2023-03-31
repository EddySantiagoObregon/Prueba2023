package com.app.hulkstore.Service;

import com.app.hulkstore.Entity.Factura;
import com.app.hulkstore.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaImp implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }
}
