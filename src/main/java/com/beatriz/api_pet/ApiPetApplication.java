package com.beatriz.api_pet;

import com.beatriz.api_pet.model.Pet;
import com.beatriz.api_pet.model.Tutor;
import com.beatriz.api_pet.repository.PetRepository;
import com.beatriz.api_pet.repository.TutorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiPetApplication implements CommandLineRunner {

	private final TutorRepository repository;
	private final PetRepository  petRepository;

    public ApiPetApplication(TutorRepository repository, PetRepository petRepository) {
        this.repository = repository;
        this.petRepository = petRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(ApiPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutor tutor1 = new Tutor(null, "beatriz", "123456-78", "123456789");
		Tutor savedTutor = repository.save(tutor1);

		Pet pet1 = new Pet(null, "Zoey", "Akita","3", "caramelo", savedTutor);
		Pet pet2 = new Pet(null, "Yuki", "Siames","11", "branco", savedTutor);

		petRepository.saveAll(List.of(pet1, pet2));
	}
}
