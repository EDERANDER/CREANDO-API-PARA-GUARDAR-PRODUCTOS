package com.practicando.apifirst2.repository;

import com.practicando.apifirst2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    /**
     * Crear producto
     * Listar productos
     * Actualizar producto por id
     * Buscar producto por id
     * Eliminar producto por id
     */

}
