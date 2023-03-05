package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Detalle_Orden;
import com.example.ProyectoFinal.Entity.Orden;
import com.example.ProyectoFinal.Repository.Detalle_OrdenRepository;
import com.example.ProyectoFinal.Repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
public class Detalle_OrdenController {

    @Autowired
    private Detalle_OrdenRepository detalle_ordenRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/detalle_ordenes")
    public List<Detalle_Orden> findAll(){
        return detalle_ordenRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/detalle_ordenNative/{id}")
    public Detalle_Orden findAllNative(@PathVariable Long id){
        return detalle_ordenRepository.findDetalleById(id);
    }

    /*@CrossOrigin(origins = "*")
    @GetMapping("/api/detalle_ordenes/totalSale")
    public Optional<Double> totalSale(){
        return detalle_ordenRepository.findAll().stream().map((x)->x.getTotalSale()).reduce((a,b)->a+b);
    }*/

    @CrossOrigin(origins = "*")
    @PostMapping("/api/detalle_ordenN")
    public ResponseEntity<Detalle_Orden> createN(@RequestBody Detalle_Orden detalle_orden){
        detalle_ordenRepository.insertDetalle(detalle_orden.getId_detalle_orden(),detalle_orden.getDetalle_cantidad(),
                detalle_orden.getDetalle_precio(),detalle_orden.getFk_orden().getId_orden(),detalle_orden.getFk_orden().getFk_producto().get(0).getId_producto());
        //detalle_ordenRepository.save(detalle_orden);
        /*detalle_ordenRepository.insert_procedure_detalle_orden(
        detalle_orden.getFk_orden().getId_orden(),detalle_orden.getFk_orden().getFk_producto().get(0).getId_producto(),
                detalle_orden.getDetalle_precio(),detalle_orden.getDetalle_cantidad());*/
        Detalle_Orden last = detalle_ordenRepository.findAll().stream().reduce((first,second)->second).orElse(null);
        return ResponseEntity.ok(last);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/detalle_orden")
    public ResponseEntity<Detalle_Orden> create(@RequestBody Detalle_Orden detalle_orden){
        Detalle_Orden result = detalle_ordenRepository.save(detalle_orden);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/detalle_ordenes/totalOrder")
    public long totalOrder(){
        return detalle_ordenRepository.count();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/detalle_orden/{id}")
    public ResponseEntity<Detalle_Orden> findOneById(@PathVariable Long id){
        if(!detalle_ordenRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Optional<Detalle_Orden> respuesta = detalle_ordenRepository.findById(id);
        return ResponseEntity.ok(respuesta.get());
    }

    @CrossOrigin(origins = "*")
    @Transactional(readOnly = false)
    @GetMapping("/api/detalle_ordenL/{id}")
    public ResponseEntity<List<Detalle_Orden>> findOneByIdList(@PathVariable Long id){
        //List<Detalle_Orden> result = detalle_ordenRepository.findAll().stream().filter((x)->x.getFk_orden().getId_orden()==id).toList();
        List<Detalle_Orden> result = detalle_ordenRepository.read_byIdOrden_detalle_orden(id);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/detalle_ordenN/{id}")
    public ResponseEntity<Orden> deleteN(@PathVariable Long id){
        detalle_ordenRepository.deleteByNativeId(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/detalle_ordenD/{id}")
    public ResponseEntity<Orden> deleteDetalleN(@PathVariable Long id){
        //detalle_ordenRepository.deleteDetalleByNativeId(id);
        detalle_ordenRepository.delete_all_procedure_detalle_orden(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/detalle_orden/{id}")
    public ResponseEntity<Orden> delete(@PathVariable Long id) {
        detalle_ordenRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
