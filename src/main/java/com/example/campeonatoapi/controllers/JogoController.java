package com.example.campeonatoapi.controllers;

import com.example.campeonatoapi.models.JogoModel;
import com.example.campeonatoapi.repositories.JogoRepository;
import com.example.campeonatoapi.requests.JogoRequest;
import com.example.campeonatoapi.responses.JogoResponse;
import com.example.campeonatoapi.services.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class JogoController {
    @Autowired
    JogoRepository jogoRepository;

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping("/jogos")
    public ResponseEntity<JogoModel> salvarJogo (@RequestBody @Valid JogoRequest jogoResquest){
        var jogoModel = new JogoModel();
        BeanUtils.copyProperties(jogoResquest, jogoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoRepository.save(jogoModel));
    }

    @GetMapping("/jogos")
    public ResponseEntity<List<JogoResponse>> listarTodosJogos(){
        return ResponseEntity.status(HttpStatus.OK).body(jogoService.buscarTodosJogos());
    }

    @GetMapping("/jogos/{id}")
    public ResponseEntity<JogoResponse> listarUmJogo(@PathVariable(value="id") UUID id){
        var jogo = jogoService.buscarJogo(id);
        return ResponseEntity.status(HttpStatus.OK).body(jogo);
    }

    @PutMapping("/jogos/{id}")
    public ResponseEntity<Object> atualizarJogo(@PathVariable(value="id") UUID id,
                                             @RequestBody @Valid JogoRequest jogoResquest) {
        return ResponseEntity.status(HttpStatus.OK).body(jogoService.atualizarJogo(id, jogoResquest));
    }

    @DeleteMapping("/jogos/{id}")
    public ResponseEntity<Object> deletarJogo(@PathVariable(value="id") UUID id) {
        jogoService.deletarJogo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Jogo deletado.");
    }
}
