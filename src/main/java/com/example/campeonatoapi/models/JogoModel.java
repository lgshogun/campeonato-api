package com.example.campeonatoapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class JogoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jogo_id")
    private UUID idJogo;
    private String nomeJogo;
}
