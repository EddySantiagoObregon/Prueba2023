package com.app.hulkstore.Service;

import com.app.hulkstore.Controller.ProductoController;
import com.app.hulkstore.Dto.*;
import com.app.hulkstore.Entity.Factura;
import com.app.hulkstore.Entity.Producto;
import com.app.hulkstore.Mapper.ProductoMapper;
import com.app.hulkstore.Repository.FacturaRepository;
import com.app.hulkstore.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public ResponseProductosDto listarProductos() {
        try {
            List<ProductoDto> productosDto = new ArrayList<>();
            List<Producto> productos = productoRepository.findAll();
            for (Producto producto : productos) {
                ProductoDto productoDto = new ProductoDto();
                System.out.println(producto);
                productoDto = ProductoMapper.ProductoEntityToDto(producto);
                productosDto.add(productoDto);
            }
            return ResponseProductosDto.builder().productoDtos(productosDto).codResponse(200).estado("OK").mensaje("Se listo correctamente").build();
        } catch (Exception ex) {
            return ResponseProductosDto.builder().productoDtos(null).codResponse(400).estado("FAIL").mensaje(ex.getMessage()).build();

        }
    }

    @Override
    public ResponseVentaProductoDto venderProducto(RequestVentaGeneralDto requestVentaGeneralDto) {
        try {
            Factura unaFactura = new Factura();
            List<Producto> productos = new ArrayList<>();
            double sumaTotal = 0;
            for (RequestVentaDto requestVentaDto: requestVentaGeneralDto.getVenta()){
                Producto producto = productoRepository.getById(requestVentaDto.getIdProducto());
                ProductoDto productoDto = ProductoMapper.ProductoEntityToDto(producto);
                if (requestVentaDto.getCantidadVenta() <= productoDto.getCantidad()) {
                    int cantidadNueva = productoDto.getCantidad() - requestVentaDto.getCantidadVenta();
                    producto.setCantidad(cantidadNueva);
                    productos.add(producto);
                    sumaTotal += productoDto.getCantidad()*productoDto.getPrecio();
                }else{
                    return ResponseVentaProductoDto.builder().codResponse(201).mensaje("No hay esta cantidad disponible para este producto: Nombre producto: "+productoDto.getNombre()).build();
                }
            }
            productoRepository.saveAll(productos);
            unaFactura.setProductos(productos);
            unaFactura.setCodFactura(generarCodigo());
            unaFactura.setValorTotalProductos(sumaTotal);
            facturaRepository.save(unaFactura);
            return ResponseVentaProductoDto.builder().codResponse(200).estado("OK").mensaje("Venta generada correctamente").build();

        } catch (Exception ex) {
            return ResponseVentaProductoDto.builder().codResponse(500).estado("Faill").mensaje(ex.getMessage()).build();
        }
    }

    public static String generarCodigo(){
        Random random = new Random();
        long codigo = (long) (random.nextDouble() * 1000000000000L);
        System.out.println("codigo"+codigo);
        String d = String.valueOf( codigo);
        return d;
    }
}






