package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findByproducNombreLike(String valor);

}
