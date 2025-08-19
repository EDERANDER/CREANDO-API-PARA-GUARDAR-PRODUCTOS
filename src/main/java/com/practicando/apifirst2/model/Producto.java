package com.practicando.apifirst2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double precioFinal;


    public Producto(Long id, String nombre, int cantidad, double precioUnitario){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        setPrecioFInal();
    }

    public Producto() {}

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioFInal() {
        return precioFinal;
    }

    public void setPrecioFInal() {
        this.precioFinal = this.precioUnitario * this.cantidad;
    }
}
