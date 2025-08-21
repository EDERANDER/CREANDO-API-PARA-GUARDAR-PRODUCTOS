package com.practicando.apifirst2.controller;

import com.practicando.apifirst2.dto.ProductoDto;
import com.practicando.apifirst2.model.Producto;
import com.practicando.apifirst2.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private ProductoService service;

    public  ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Producto guardarProducto(@Valid @RequestBody ProductoDto producto) {
        return service.guardarProducto(producto.getNombre(), producto.getCantidad(), producto.getPrecioUnitario());
    }

    @GetMapping("/get")
    public List<Producto> listaProductos(){
        return service.listaProductos();
    }

    @PutMapping("/update")
    public Optional<Producto> actualizarProducto(@Valid @RequestBody ProductoDto producto) {
        return service.actualizarProducto(producto.getId(), producto.getNombre(), producto.getCantidad(), producto.getPrecioUnitario());
    }

    @GetMapping("/find/{id}")
    public Optional<Producto> buscarProducto(@PathVariable Long id) {
        return service.buscarProducto(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarProducto(@PathVariable  Long id) {
        service.eliminarProducto(id);
    }
}


