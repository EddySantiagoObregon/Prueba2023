package com.app.hulkstore.Repository;

import com.app.hulkstore.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    ArrayList<Producto> findAll();
}
