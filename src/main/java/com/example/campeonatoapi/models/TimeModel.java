package com.example.campeonatoapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_TIMES")
public class TimeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_id")
    private UUID idTime;
    private String nomeTime;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private JogoModel jogo;

    @ManyToOne
    @JoinColumn(name = "jogadores_id")
    private UsuarioModel jogadores;

    @ManyToOne
    @JoinColumn(name = "lideres_id")
    private UsuarioModel lider;

    public TimeModel() {
    }

    public TimeModel(UUID idTime, String nomeTime, JogoModel jogo, UsuarioModel jogadores, UsuarioModel lider) {
        this.idTime = idTime;
        this.nomeTime = nomeTime;
        this.jogo = jogo;
        this.jogadores = jogadores;
        this.lider = lider;
    }

    public UUID getIdTime() {
        return idTime;
    }

    public void setIdTime(UUID idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public JogoModel getJogo() {
        return jogo;
    }

    public void setJogo(JogoModel jogo) {
        this.jogo = jogo;
    }

    public UsuarioModel getJogadores() {
        return jogadores;
    }

    public void setJogadores(UsuarioModel jogadores) {
        this.jogadores = jogadores;
    }

    public UsuarioModel getLider() {
        return lider;
    }

    public void setLider(UsuarioModel lider) {
        this.lider = lider;
    }
}
