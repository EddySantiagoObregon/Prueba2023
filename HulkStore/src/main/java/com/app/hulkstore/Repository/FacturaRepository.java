package com.app.hulkstore.Repository;

import com.app.hulkstore.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
