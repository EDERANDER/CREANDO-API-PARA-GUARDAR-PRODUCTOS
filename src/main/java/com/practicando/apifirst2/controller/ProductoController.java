package com.practicando.apifirst2.controller;

import com.practicando.apifirst2.model.Producto;
import com.practicando.apifirst2.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private ProductoService service;

    public  ProductoController(ProductoService service)
    {
        this.service = service;
    }

    @PostMapping("/guardar-producto")
    public Producto guardarProducto(@RequestBody Producto producto)
    {
        return service.guardarProducto(producto.getNombre(), producto.getCantidad(), producto.getPrecioUnitario());
    }

    @GetMapping("/listar-productos")
    public List<Producto> listaProductos(){
        return service.listaProductos();
    }

    @PutMapping("/actualizar-producto")
    public Optional<Producto> actualizarProducto(@RequestBody Producto producto)
    {
        return service.actualizarProducto(producto.getId(), producto.getNombre(), producto.getCantidad(), producto.getPrecioUnitario());
    }

    @GetMapping("/buscar-producto/{id}")
    public Optional<Producto> buscarProducto(@PathVariable Long id)
    {
        return service.buscarProducto(id);
    }

    @DeleteMapping("/eliminar-producto/{id}")
    public void eliminarProducto(Long id)
    {
        service.eliminarProducto(id);
    }
}


