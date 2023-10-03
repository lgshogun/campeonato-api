package com.example.campeonatoapi.services;

import com.example.campeonatoapi.models.JogoModel;
import com.example.campeonatoapi.repositories.JogoRepository;
import com.example.campeonatoapi.requests.JogoRequest;
import com.example.campeonatoapi.responses.JogoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<JogoResponse> buscarTodosJogos(){
        List<JogoResponse> jogoResponseList = new ArrayList<>();
        final var listaTodosJogos = jogoRepository.findAll();
        for(JogoModel jogoModel : listaTodosJogos){
            jogoResponseList.add(
                    new JogoResponse(
                            jogoModel.getIdJogo(),
                            jogoModel.getNomeJogo()
                    )
            );
        }
        return jogoResponseList;
    }

    public JogoResponse buscarJogo(UUID id){
        final var jogo = buscarPorIdJogo(id);
        return new JogoResponse(jogo.getIdJogo(),jogo.getNomeJogo());
    }

    private JogoModel buscarPorIdJogo(UUID id) {
        final var jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado."));
        return jogo;
    }

    public JogoResponse atualizarJogo(UUID id, JogoRequest jogoRequest){
        final var jogo = buscarPorIdJogo(id);
        BeanUtils.copyProperties(jogoRequest, jogo);
        jogoRepository.save(jogo);
        return new JogoResponse(jogo.getIdJogo(), jogo.getNomeJogo());
    }

    public void deletarJogo(UUID id){
        final var jogo = buscarPorIdJogo(id);
        jogoRepository.delete(jogo);
    }
}
