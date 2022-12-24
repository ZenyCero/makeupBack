package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Producto;
import com.example.ProyectoFinal.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/productos")
    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/producto/{id}")
    public ResponseEntity<Producto> findOneById(@PathVariable Long id){
        if(!productoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Optional<Producto> respuesta = productoRepository.findById(id);
        return ResponseEntity.ok(respuesta.get());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/productoN/{name}")
    public ResponseEntity<List<Producto>> findOneByProducName(@PathVariable String name){
        String likePattern = "%"+name+"%";
        if(productoRepository.findByproducNombreLike(likePattern) == null){
            return ResponseEntity.notFound().build();
        }
        List<Producto> respuesta = productoRepository.findByproducNombreLike(likePattern).stream().filter(x->x.getProducStock()>10).toList();
        return ResponseEntity.ok(respuesta.stream().toList());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/productos/totalStock")
    public Optional<Integer> totalStock(){
        return productoRepository.findAll().stream().map((x)-> x.getProducStock()).reduce((a,b)->a+b);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/producto")
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto result = productoRepository.save(producto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/producto")
    public ResponseEntity<Producto> update(@RequestBody Producto producto){
        if(!productoRepository.existsById(producto.getId_producto())){
            return ResponseEntity.notFound().build();
        }
        Producto result = productoRepository.save(producto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/producto/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id){
        if(!productoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
