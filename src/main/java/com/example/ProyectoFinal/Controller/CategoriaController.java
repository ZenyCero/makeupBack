package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Categoria;
import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/categorias")
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/categoriaN/{id}")
    public ResponseEntity<Categoria> findOneById(@PathVariable Long id){
        if(!categoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Optional<Categoria> respuesta = categoriaRepository.findById(id);
        return ResponseEntity.ok(respuesta.get());
    }
}
