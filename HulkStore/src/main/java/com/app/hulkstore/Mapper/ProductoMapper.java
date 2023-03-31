package com.app.hulkstore.Mapper;

import com.app.hulkstore.Dto.ProductoDto;
import com.app.hulkstore.Entity.Categoria;
import com.app.hulkstore.Entity.Producto;
import com.app.hulkstore.Repository.CategoriaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoMapper {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static ProductoDto ProductoEntityToDto(Producto producto){
        ProductoDto productoDto= new ProductoDto();
        productoDto.setIdProducto(producto.getIdProducto());
        productoDto.setNombre(producto.getNombre());
        productoDto.setCategoria(producto.getCategoria().getNombre());
        productoDto.setCantidad(producto.getCantidad());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setEstado(producto.getEstado());
        System.out.println(productoDto);
        return productoDto;
    }
    public Producto ProductoDtoToEntity(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setIdProducto(productoDto.getIdProducto());
        producto.setNombre(productoDto.getNombre());
        producto.setCantidad(productoDto.getCantidad());
        producto.setPrecio(productoDto.getPrecio());
        producto.setEstado(productoDto.getEstado());
        if (productoDto.getCategoria() != null) {
            Categoria categoria = categoriaRepository.findByNombre(productoDto.getCategoria());
            producto.setCategoria(categoria);
        } else {
            producto.setCategoria(null);
        }
        return producto;
    }

}
