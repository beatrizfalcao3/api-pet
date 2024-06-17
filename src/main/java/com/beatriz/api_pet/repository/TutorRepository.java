package com.beatriz.api_pet.repository;

import com.beatriz.api_pet.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByCpf(String cpf);
}
