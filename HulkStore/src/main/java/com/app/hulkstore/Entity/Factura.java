package com.app.hulkstore.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(name = "codFactura")
    private String codFactura;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductos")
    private List<Producto> productos;

    @Column(name = "valorTotalProductos")
    private double valorTotalProductos;

}
