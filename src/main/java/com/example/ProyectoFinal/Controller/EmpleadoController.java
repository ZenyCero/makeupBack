package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Cliente;
import com.example.ProyectoFinal.Entity.Empleado;
import com.example.ProyectoFinal.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/api/empleados")
    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/empleado/{id}")
    public ResponseEntity<Empleado> findOneById(@PathVariable Long id){
        if(!empleadoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Optional<Empleado> respuesta = empleadoRepository.findById(id);
        return ResponseEntity.ok(respuesta.get());
    }

    @CrossOrigin(origins = "*")

    @PostMapping("/api/empleado")
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado){
        Empleado result = empleadoRepository.save(empleado);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/api/empleado")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
        if(!empleadoRepository.existsById(empleado.getId_empleado())){
            return ResponseEntity.notFound().build();
        }
        Empleado result = empleadoRepository.save(empleado);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/empleado/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable Long id){
        if(!empleadoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        empleadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/empleado")
    public ResponseEntity<Empleado> deleteAll(){
        if(empleadoRepository.count() < 1){
            return ResponseEntity.badRequest().build();
        }
        empleadoRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/login")
    public ResponseEntity<Empleado> login(@RequestBody Empleado empleado){
        if (!empleadoRepository.existsByEmail(empleado.getEmail())){
            return ResponseEntity.notFound().build();
        } else if (!empleadoRepository.existsByPass(empleado.getPass())){
            return ResponseEntity.notFound().build();
        }

        Empleado result = empleadoRepository.findByEmailAndPass(empleado.getEmail(), empleado.getPass());
        return ResponseEntity.ok(result);
    }
}
