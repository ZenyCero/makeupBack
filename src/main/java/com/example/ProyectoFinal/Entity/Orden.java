package com.example.ProyectoFinal.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "fk_cliente",nullable = false)
    private Cliente fk_cliente;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "fk_empleado",nullable = false)
    private Empleado fk_empleado;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Detalle_Orden",
            joinColumns = {@JoinColumn(name = "id_detalle_orden")},
            inverseJoinColumns = {@JoinColumn(name = "fk_producto")})
    private List<Producto> fk_producto = new ArrayList<Producto>();
    @Column(nullable = false)
    private char orden_estado;
    @Column(nullable = false)
    private LocalDateTime orden_fecha;

    public Orden() {
    }

    public Orden(Long id, char orden_estado, LocalDateTime orden_fecha) {
        this.id_orden = id;
        this.orden_estado = orden_estado;
        this.orden_fecha = orden_fecha;
    }

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
    }

    public Cliente getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(Cliente fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    public char getOrden_estado() {
        return orden_estado;
    }

    public void setOrden_estado(char orden_estado) {
        this.orden_estado = orden_estado;
    }
    public LocalDateTime getOrden_fecha() {
        return orden_fecha;
    }

    public void setOrden_fecha(LocalDateTime orden_fecha) {
        this.orden_fecha = orden_fecha;
    }

    public Empleado getFk_empleado() {
        return fk_empleado;
    }

    public void setFk_empleado(Empleado fk_empleado) {
        this.fk_empleado = fk_empleado;
    }

    public List<Producto> getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(List<Producto> fk_producto) {
        this.fk_producto = fk_producto;
    }
}
