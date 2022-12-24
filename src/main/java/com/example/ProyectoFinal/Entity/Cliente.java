package com.example.ProyectoFinal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private Date fechNaci;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String sexo, String email, String dni, String fullName, String direccion, String telefono, Date fechNaci) {
        this.id_cliente = id_cliente;
        this.sexo = sexo;
        this.email = email;
        this.dni = dni;
        this.fullName = fullName;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechNaci = fechNaci;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(Date fechNaci) {
        this.fechNaci = fechNaci;
    }
}
