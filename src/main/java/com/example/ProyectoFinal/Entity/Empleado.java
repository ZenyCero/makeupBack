package com.example.ProyectoFinal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;
    @Column(nullable = false)
    private char sexo;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String full_name;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private Integer telefono;
    @Column(nullable = false)
    private Date fechNaci;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private String pass;

    public Empleado() {
    }

    public Empleado(Long id_empleado, char sexo, String email, String dni, String full_name, String direccion, Integer telefono, Date fechNaci, String cargo, String pass) {
        this.id_empleado = id_empleado;
        this.sexo = sexo;
        this.email = email;
        this.dni = dni;
        this.full_name = full_name;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechNaci = fechNaci;
        this.cargo = cargo;
        this.pass = pass;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(Date fechNaci) {
        this.fechNaci = fechNaci;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
