package com.example.campeonatoapi.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIOS")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private UUID idUsuario;
    private String nomeUsuario;
    private Boolean liderOuJogador; // False para Jogador, True para Lider

    @ManyToOne
    @JoinColumn(name = "jogos_id")
    private JogoModel jogo;

    @ManyToOne
    @JoinColumn(name = "times_id")
    private TimeModel time;

    public UsuarioModel() {
    }

    public UsuarioModel(UUID idUsuario, String nomeUsuario, Boolean liderOuJogador, JogoModel jogo, TimeModel time) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.liderOuJogador = liderOuJogador;
        this.jogo = jogo;
        this.time = time;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Boolean getLiderOuJogador() {
        return liderOuJogador;
    }

    public void setLiderOuJogador(Boolean liderOuJogador) {
        this.liderOuJogador = liderOuJogador;
    }

    public JogoModel getJogo() {
        return jogo;
    }

    public void setJogo(JogoModel jogo) {
        this.jogo = jogo;
    }

    public TimeModel getTime() {
        return time;
    }

    public void setTime(TimeModel time) {
        this.time = time;
    }
}