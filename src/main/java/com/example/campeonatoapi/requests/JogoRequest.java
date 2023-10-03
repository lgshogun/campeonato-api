package com.example.campeonatoapi.requests;

import jakarta.validation.constraints.NotBlank;

public record JogoRequest(@NotBlank String nomeJogo) {
}
