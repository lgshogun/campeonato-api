package com.example.campeonatoapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class UsuárioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private UUID idUsuario;
    private String nomeUsuario;
}