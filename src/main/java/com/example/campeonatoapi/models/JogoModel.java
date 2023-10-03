package com.example.campeonatoapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_JOGOS")
public class JogoModel implements Serializable {
    public static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jogo_id")
    private UUID idJogo;
    private String nomeJogo;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.REMOVE)
    private List<TimeModel> times;
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.REMOVE)
    private List<UsuarioModel> usuarios;

    public JogoModel() {
    }

    public JogoModel(UUID idJogo, String nomeJogo, List<TimeModel> times, List<UsuarioModel> usuarios) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.times = times;
        this.usuarios = usuarios;
    }

    public UUID getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(UUID idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public List<TimeModel> getTimes() {
        return times;
    }

    public void setTimes(List<TimeModel> times) {
        this.times = times;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }
}
