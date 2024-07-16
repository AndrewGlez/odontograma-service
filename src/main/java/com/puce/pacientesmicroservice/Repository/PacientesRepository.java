package com.puce.pacientesmicroservice.Repository;

import com.puce.pacientesmicroservice.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Paciente, Integer> {

}
