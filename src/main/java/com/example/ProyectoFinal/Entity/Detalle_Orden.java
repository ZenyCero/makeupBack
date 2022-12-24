package com.example.ProyectoFinal.Entity;

import javax.persistence.*;

@Entity
public class Detalle_Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_orden;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_orden",nullable = false)
    private Orden fk_orden;
    @Column(nullable = false)
    private Double detalle_precio;
    @Column(nullable = false)
    private Integer detalle_cantidad;

    public Detalle_Orden() {
    }

    public Detalle_Orden(Long id_detalle_orden, Double detalle_precio, Integer detalle_cantidad) {
        this.id_detalle_orden = id_detalle_orden;
        this.detalle_precio = detalle_precio;
        this.detalle_cantidad = detalle_cantidad;
    }

    public Long getId_detalle_orden() {
        return id_detalle_orden;
    }

    public void setId_detalle_orden(Long id_detalle_orden) {
        this.id_detalle_orden = id_detalle_orden;
    }

    public Orden getFk_orden() {
        return fk_orden;
    }

    public void setFk_orden(Orden fk_orden) {
        this.fk_orden = fk_orden;
    }

    public Double getDetalle_precio() {
        return detalle_precio;
    }

    public void setDetalle_precio(Double detalle_precio) {
        this.detalle_precio = detalle_precio;
    }

    public Integer getDetalle_cantidad() {
        return detalle_cantidad;
    }

    public void setDetalle_cantidad(Integer detalle_cantidad) {
        this.detalle_cantidad = detalle_cantidad;
    }

}
