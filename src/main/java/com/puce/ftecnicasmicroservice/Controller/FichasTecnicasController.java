package com.puce.ftecnicasmicroservice.Controller;

import com.puce.ftecnicasmicroservice.Entity.FichasTecnicas;
import com.puce.ftecnicasmicroservice.Respository.FichasTecnicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fichas")
@CrossOrigin("*")
public class FichasTecnicasController {

    @Autowired
    private FichasTecnicasRepository FichasTecnicasRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FichasTecnicas> findAll() {
        return FichasTecnicasRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<FichasTecnicas> findById(@PathVariable Integer id) {
        return FichasTecnicasRepository.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public FichasTecnicas add(@RequestBody FichasTecnicas FichasTecnicas) {
        return FichasTecnicasRepository.save(FichasTecnicas);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody HashMap<String, String> body) {
        FichasTecnicas fichasTecnica = FichasTecnicasRepository.getReferenceById(Integer.valueOf(body.get("id")));
        fichasTecnica.setMedication(body.get("medication"));
        fichasTecnica.setBudget(Double.valueOf(body.get("budget")));
        fichasTecnica.setDescription(body.get("description"));
        fichasTecnica.setTratamientos(body.get("tratamientos"));
        fichasTecnica.setPaciente_id(Integer.valueOf(body.get("paciente_id")));
        fichasTecnica.set_paid(Boolean.parseBoolean(body.get("_paid")));
        FichasTecnicasRepository.save(fichasTecnica);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody HashMap<String, String> body) {
        FichasTecnicasRepository.deleteById(Integer.valueOf(body.get("id")));

        return new ResponseEntity<>("Ficha técnica deleted successfully" ,HttpStatus.OK);
    }


}
