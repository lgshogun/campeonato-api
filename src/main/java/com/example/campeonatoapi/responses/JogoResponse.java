package com.example.campeonatoapi.responses;

import java.util.UUID;

public record JogoResponse(
        UUID idJogo,
        String nomeJogo
) {
}
