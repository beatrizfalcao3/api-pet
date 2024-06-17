package com.beatriz.api_pet.repository;

import com.beatriz.api_pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findByTutorId(Long tutorId);
}
