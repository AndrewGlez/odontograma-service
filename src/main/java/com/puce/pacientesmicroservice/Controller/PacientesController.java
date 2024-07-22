package com.puce.pacientesmicroservice.Controller;

import com.puce.pacientesmicroservice.Entity.Paciente;
import com.puce.pacientesmicroservice.Repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacientesController {

    @Autowired
    private PacientesRepository PacientesRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Paciente> getAllPacientes() {
        return PacientesRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente addPaciente(@RequestBody Paciente paciente) {
        return PacientesRepository.save(paciente);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Paciente> getPaciente(@PathVariable int id) {
        return PacientesRepository.findById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Paciente updatePaciente(@RequestBody HashMap<String, String> body) {
        Paciente paciente = PacientesRepository.getReferenceById(Integer.valueOf(body.get("id")));
        paciente.setName(body.get("name"));
        paciente.setSurname(body.get("surname"));
        paciente.setAddress(body.get("address"));
        paciente.setPhone(body.get("phone"));
        paciente.setEmail(body.get("email"));
        return PacientesRepository.save(paciente);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePaciente(@RequestBody HashMap<String, Integer> body) {
        Paciente paciente = PacientesRepository.getById(body.get("id"));
        PacientesRepository.delete(paciente);
        return new ResponseEntity<>("Paciente deleted successfully", HttpStatus.OK);
    }

}
