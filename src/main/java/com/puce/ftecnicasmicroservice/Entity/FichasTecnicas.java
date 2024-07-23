package com.puce.ftecnicasmicroservice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "fichas_tecnicas")
@Getter
@Setter
@NoArgsConstructor
public class FichasTecnicas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double budget;
    private Integer paciente_id;
    private String medication;
    private String description;
    private String tratamientos;
    private boolean is_paid;
}
