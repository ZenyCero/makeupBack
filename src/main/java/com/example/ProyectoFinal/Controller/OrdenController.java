package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Orden;
import com.example.ProyectoFinal.Repository.OrdenRepository;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class OrdenController{
    @Autowired
    private OrdenRepository ordenRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/ordenes")
    public List<Orden> findAll(){
        return ordenRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/ordenesEC")
    public List<Orden> findAllEC(){
        List<Orden> result = ordenRepository.findAll().stream().filter((x)->x.getOrden_estado()=='C').toList();
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/ordenesEP")
    public List<Orden> findAllEP(){
        List<Orden> result = ordenRepository.findAll().stream().filter((x)->x.getOrden_estado()=='P').toList();
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/ordenesEA")
    public List<Orden> findAllEA(){
        List<Orden> result = ordenRepository.findAll().stream().filter((x)->x.getOrden_estado()=='A').toList();
        return result;
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/orden")
    public ResponseEntity<Orden> update(@RequestBody Orden orden){
        if(!ordenRepository.existsById(orden.getId_orden())){
            return ResponseEntity.notFound().build();
        }
        Orden result = ordenRepository.save(orden);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/orden")
    public ResponseEntity<Orden> create(@RequestBody Orden orden){
        Orden result = ordenRepository.save(orden);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/ordenN/{id}")
    public ResponseEntity<Orden> deleteN(@PathVariable Long id){
        if(!ordenRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ordenRepository.deleteByNativeId(id);
        return ResponseEntity.ok().build();
    }
}
