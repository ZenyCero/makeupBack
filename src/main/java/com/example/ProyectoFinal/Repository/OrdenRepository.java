package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Long> {
    @Transactional
    @Modifying
    @Query("delete from #{#entityName} b where b.id_orden=:id")
    void deleteByNativeId(@Param("id") Long id);
}
