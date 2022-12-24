package com.example.ProyectoFinal.Entity;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    @Column(nullable = false)
    private String cate_nombre;

    public Categoria() {
    }

    public Categoria(Long id, String cate_nombre) {
        this.id_categoria = id;
        this.cate_nombre = cate_nombre;
    }

    public Long getId() {
        return id_categoria;
    }

    public void setId(Long id) {
        this.id_categoria = id_categoria;
    }

    public String getCate_nombre() {
        return cate_nombre;
    }

    public void setCate_nombre(String cate_nombre) {
        this.cate_nombre = cate_nombre;
    }

}
