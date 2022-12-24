package com.example.ProyectoFinal.Entity;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_categoria",nullable = false)
    private Categoria fk_categoria;
    @Column(nullable = false)
    private String producSku;
    @Column(nullable = false)
    private String producNombre;
    @Column(nullable = false)
    private Double producPrecio;
    @Column(nullable = false)
    private String producMarca;
    @Column(nullable = false)
    private Integer producStock;

    public Producto() {
    }

    public Producto(Long id_producto, Categoria fk_categoria, String producSku, String producNombre, Double producPrecio, String producMarca, Integer producStock) {
        this.id_producto = id_producto;
        this.fk_categoria = fk_categoria;
        this.producSku = producSku;
        this.producNombre = producNombre;
        this.producPrecio = producPrecio;
        this.producMarca = producMarca;
        this.producStock = producStock;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Categoria getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(Categoria fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getProducSku() {
        return producSku;
    }

    public void setProducSku(String producSku) {
        this.producSku = producSku;
    }

    public String getProducNombre() {
        return producNombre;
    }

    public void setProducNombre(String producNombre) {
        this.producNombre = producNombre;
    }

    public Double getProducPrecio() {
        return producPrecio;
    }

    public void setProducPrecio(Double producPrecio) {
        this.producPrecio = producPrecio;
    }

    public String getProducMarca() {
        return producMarca;
    }

    public void setProducMarca(String producMarca) {
        this.producMarca = producMarca;
    }

    public Integer getProducStock() {
        return producStock;
    }

    public void setProducStock(Integer producStock) {
        this.producStock = producStock;
    }
}
