package com.example.campeonatoapi.repositories;

import com.example.campeonatoapi.models.TimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeRepository extends JpaRepository<TimeModel, UUID> {
}
