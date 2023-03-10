package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Detalle_Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface Detalle_OrdenRepository extends JpaRepository<Detalle_Orden,Long> {
    @Transactional
    @Modifying
    @Query(
            value =
                    "insert into #{#entityName} (id_detalle_orden,detalle_cantidad,detalle_precio,fk_orden,fk_producto) values (:id_detalle_orden,:detalle_cantidad, :detalle_precio, :fk_orden, :fk_producto)",
            nativeQuery = true)
    void insertDetalle(@Param("id_detalle_orden") Long id_detalle_orden,@Param("detalle_cantidad") Integer detalle_cantidad, @Param("detalle_precio") Double detalle_precio,
                    @Param("fk_orden") Long fk_orden, @Param("fk_producto") Long fk_producto);


    @Transactional
    @Modifying
    @Query("delete from #{#entityName} b where b.fk_orden=:id")
    void deleteByNativeId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("delete from #{#entityName} b where b.id_detalle_orden=:id")
    void deleteDetalleByNativeId(@Param("id") Long id);

    @Query(value="select * from detalle_orden d where d.id_detalle_orden = id", nativeQuery = true)
    Detalle_Orden findDetalleById(@Param("id") Long id);

    @Procedure(value = "insert_detalle_orden")
    void insert_procedure_detalle_orden(Long id_orden,Long id_producto,Double precio, Integer cantidad);

    @Procedure(value = "delete_all_detalle_orden")
    void delete_all_procedure_detalle_orden(Long fk_orden);

    @Procedure(value = "read_byIdOrden_detalle_orden")
    List<Detalle_Orden> read_byIdOrden_detalle_orden(Long fk_orden);
}
