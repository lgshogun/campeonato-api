package com.example.campeonatoapi.repositories;

import com.example.campeonatoapi.models.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, UUID> {
}
