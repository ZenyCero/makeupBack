package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByfullNameLike(String valor);
}
