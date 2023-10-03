package com.example.campeonatoapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class TimeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_id")
    private UUID idTime;
    private String nomeTime;
}
