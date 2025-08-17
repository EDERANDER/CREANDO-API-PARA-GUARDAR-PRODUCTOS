package com.practicando.apifirst2.service;

import com.practicando.apifirst2.model.Producto;
import com.practicando.apifirst2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }

    public Producto guardarProducto(String nombre,
                                    int cantidad,
                                    double precioUnitario){
        Producto producto = new Producto(null,nombre, cantidad, precioUnitario);
        return repository.save(producto);
    }

    public List<Producto> listaProductos(){
        return repository.listar();
    }

    public Optional<Producto> actualizarProducto(Long id,
                                                 String nombre,
                                                 int cantidad,
                                                 double precioUnitario)
    {
        Producto producto = new Producto(id, nombre, cantidad, precioUnitario);
        return repository.actualizar(producto);
    }

    public Optional<Producto> buscarProducto(Long id){
        return repository.buscar(id);
    }

    public void eliminarProducto(Long id){
        repository.eliminar(id);
    }

}
