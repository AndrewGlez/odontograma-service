package com.puce.pacientesmicroservice.Controller;

import com.puce.pacientesmicroservice.Entity.Receptionistas;
import com.puce.pacientesmicroservice.Repository.RecepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/recepcion")
@CrossOrigin("*")
public class RecepcionistasController {
    @Autowired
    private RecepRepository RecepRepository;

    @GetMapping
    public List<Receptionistas> getAllRecepcionistas(){
        return RecepRepository.findAll();
    }

    @GetMapping("/{id}")
    public Receptionistas getRecepcionistasById(@RequestParam int id){
        return RecepRepository.findById(id).get();
    }

    @PostMapping("/create")
    public Receptionistas saveRecepcionistas(@RequestBody Receptionistas receptionistas){
        return RecepRepository.save(receptionistas);
    }

    @PutMapping("/update")
    public Receptionistas updateRecepcionistas(@RequestBody HashMap<String, String> body){
        Receptionistas receptionistas = RecepRepository.getReferenceById(Integer.parseInt(body.get("id")));
        receptionistas.setNombre(body.get("nombre"));
        receptionistas.setDireccion(body.get("direccion"));
        receptionistas.setApellido(body.get("apellido"));
        receptionistas.setEmail(body.get("email"));
        receptionistas.setTelefono(body.get("telefono"));
        receptionistas.setContraseña(body.get("contraseña"));
        return RecepRepository.save(receptionistas);
    }

    @DeleteMapping("/delete")
    public void deleteRecepcionistas(@RequestBody HashMap<String, String> body){
        RecepRepository.deleteById(Integer.parseInt(body.get("id")));
    }
}
