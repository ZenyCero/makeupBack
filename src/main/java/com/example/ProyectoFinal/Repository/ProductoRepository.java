package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findByproducNombreLike(String valor);
    @Transactional
    @Modifying
    @Query("update #{#entityName} u set u.fk_categoria = :fk_categoria," +
            "u.producMarca = :marca,u.producNombre = :nombre,u.producSku = :sku" +
            ",u.producPrecio = :precio,u.producStock = :stock where u.id_producto = :id")

    Integer updateNative(@Param("id") Long id_producto,@Param("fk_categoria") Long fk_categoria,
                                   @Param("marca") String produc_marca,@Param("nombre") String produc_nombre,
                                    @Param("sku") String produc_sku,@Param("precio") Double produc_precio,
                                   @Param("stock") Integer produc_stock);

}
