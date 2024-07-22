package com.puce.pacientesmicroservice.Controller;

import com.puce.pacientesmicroservice.Entity.Odontologos;
import com.puce.pacientesmicroservice.Repository.OdontologosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
@CrossOrigin("*")
public class OdontologosController {
    @Autowired
    private OdontologosRepository odontologosRepository;

    @GetMapping
    public List<Odontologos> getAllOdontologos(){
        return odontologosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Odontologos getOdontologosById(@RequestParam int id){
        return odontologosRepository.findById(id).get();
    }

    @PostMapping("/create")
    public Odontologos saveOdontologos(@RequestBody Odontologos odontologos){
        return odontologosRepository.save(odontologos);
    }

    @PutMapping("/update")
    public Odontologos updateOdontologos(@RequestBody HashMap<String, String> body){
        Odontologos odontologo = odontologosRepository.getReferenceById(Integer.parseInt(body.get("id")));
        odontologo.setNombre(body.get("nombre"));
        odontologo.setApellidos(body.get("apellidos"));
        odontologo.setDireccion(body.get("direccion"));
        odontologo.setEmail(body.get("email"));
        odontologo.setTelefono(body.get("telefono"));
        odontologo.setContraseña(body.get("contraseña"));
        return odontologosRepository.save(odontologo);
    }

    @DeleteMapping("/delete")
    public void deleteOdontologos(@RequestBody HashMap<String, String> body){
        odontologosRepository.deleteById(Integer.parseInt(body.get("id")));
    }


}
