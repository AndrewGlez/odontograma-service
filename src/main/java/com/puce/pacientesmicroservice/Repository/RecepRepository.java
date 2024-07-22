package com.puce.pacientesmicroservice.Repository;

import com.puce.pacientesmicroservice.Entity.Receptionistas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecepRepository extends JpaRepository<Receptionistas, Integer> {
}
