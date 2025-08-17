package com.practicando.apifirst2.repository;

import com.practicando.apifirst2.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    /**
     * Crear producto
     * Listar productos
     * Actualizar producto por id
     * Buscar producto por id
     * Eliminar producto por id
     */

    Producto save(Producto producto);
    List<Producto> listar ();
    Optional<Producto> actualizar(Producto nuevoProducto);
    Optional<Producto> buscar(Long id);
    void eliminar(Long id);
}
