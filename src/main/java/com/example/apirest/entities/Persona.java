package com.example.apirest.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Table (name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Persona implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
}
