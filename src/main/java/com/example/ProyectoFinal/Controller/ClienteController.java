package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Producto;
import com.example.ProyectoFinal.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/clientes")
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/cliente/{id}")
    public ResponseEntity<Cliente> findOneById(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Optional<Cliente> respuesta = clienteRepository.findById(id);
        return ResponseEntity.ok(respuesta.get());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/clienteN/{name}")
    public ResponseEntity<List<Cliente>> findOneByProducName(@PathVariable String name){
        String likePattern = "%"+name+"%";
        if(clienteRepository.findByfullNameLike(likePattern) == null){
            return ResponseEntity.notFound().build();
        }
        List<Cliente> respuesta = clienteRepository.findByfullNameLike(likePattern);
        return ResponseEntity.ok(respuesta.stream().toList());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/cliente")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        Cliente result = clienteRepository.save(cliente);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/cliente")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        if(!clienteRepository.existsById(cliente.getId_cliente())){
            return ResponseEntity.notFound().build();
        }
        Cliente result = clienteRepository.save(cliente);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/cliente/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/cliente")
    public ResponseEntity<Cliente> deleteAll(){
        if(clienteRepository.count() < 1){
            return ResponseEntity.badRequest().build();
        }
        clienteRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
