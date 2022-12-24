package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    Boolean existsByEmail(String email);
    Boolean existsByPass(String pass);

    Empleado findByEmailAndPass(String email,String pass);
}
