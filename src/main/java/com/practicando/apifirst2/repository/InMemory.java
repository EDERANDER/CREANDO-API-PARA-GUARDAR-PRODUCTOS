package com.practicando.apifirst2.repository;
import com.practicando.apifirst2.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class InMemory implements ProductoRepository{

    private Map<Long, Producto> almacenamiento = new HashMap<>();
    private Long numerador = 0L;
    @Override
    public Producto save(Producto producto) {
        if (producto.getId() == null){
            producto.setId(numerador++);
        }
        almacenamiento.put(producto.getId(), producto);
        return producto;
    }

    @Override
    public List<Producto> listar() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public Optional<Producto> actualizar(Producto nuevoProducto) {
        if (almacenamiento.containsKey(nuevoProducto.getId())) {
            Producto productoExistente = almacenamiento.get(nuevoProducto.getId());
            productoExistente.setNombre(nuevoProducto.getNombre());
            productoExistente.setCantidad(nuevoProducto.getCantidad());
            productoExistente.setPrecioUnitario(nuevoProducto.getPrecioUnitario());
            productoExistente.setPrecioFInal();
            almacenamiento.put(nuevoProducto.getId(), productoExistente);
            return Optional.of(productoExistente);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> buscar(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public void eliminar(Long id){
        almacenamiento.remove(id);
    }
}
